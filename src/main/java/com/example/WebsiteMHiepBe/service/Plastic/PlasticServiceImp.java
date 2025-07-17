package com.example.WebsiteMHiepBe.service.Plastic;

import com.example.WebsiteMHiepBe.dao.GenreRepository;
import com.example.WebsiteMHiepBe.dao.ImageRepository;
import com.example.WebsiteMHiepBe.dao.PlasticItemReposiroty;
import com.example.WebsiteMHiepBe.entity.Genre;
import com.example.WebsiteMHiepBe.entity.Image;
import com.example.WebsiteMHiepBe.entity.PlasticItem;
import com.example.WebsiteMHiepBe.service.UploadImage.UploadImageService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.hibernate.Internal;
import org.hibernate.query.UnknownParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlasticServiceImp implements PlasticService{
    private final ObjectMapper objectMapper;
    @Autowired
    private PlasticItemReposiroty plasticItemReposiroty;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private ImageRepository imageRepository;;
    @Autowired
    private UploadImageService uploadImageService;

    public PlasticServiceImp(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    @Transactional
    public ResponseEntity<?> save(JsonNode plasticJson) {
        try {
            // Parse thông tin từ JSON thành object PlasticItem
            PlasticItem plasticItem = objectMapper.treeToValue(plasticJson, PlasticItem.class);

            // Parse danh sách ID thể loại
            List<Integer> idGenreList = objectMapper.readValue(
                    plasticJson.get("idGenres").traverse(),
                    new TypeReference<List<Integer>>() {}
            );
            List<Genre> genreList = genreRepository.findAllById(idGenreList);
            plasticItem.setListGenres(genreList);

            // Lưu trước plastic để lấy ID
            PlasticItem savedPlastic = plasticItemReposiroty.save(plasticItem);

            // Parse ảnh thumbnail
            String thumbnailUrl = plasticJson.get("thumbnail").asText();
            Image thumbnail = new Image();
            thumbnail.setPlasticItem(savedPlastic);
            thumbnail.setThumbnail(true);
            thumbnail.setUrlImage(thumbnailUrl);

            // Parse ảnh liên quan
            List<String> relatedImgUrls = objectMapper.readValue(
                    plasticJson.get("relatedImg").traverse(),
                    new TypeReference<List<String>>() {}
            );

            List<Image> allImages = new ArrayList<>();
            allImages.add(thumbnail);

            for (String url : relatedImgUrls) {
                Image image = new Image();
                image.setPlasticItem(savedPlastic);
                image.setThumbnail(false);
                image.setUrlImage(url);
                allImages.add(image);
            }

            // Gán danh sách ảnh
            savedPlastic.setListImages(allImages);

            // Lưu lại lần cuối
            plasticItemReposiroty.save(savedPlastic);

            return ResponseEntity.ok("Thêm plastic thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Lỗi khi thêm plastic: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> update(JsonNode plasticJson) {
        try {
            // Parse object
            PlasticItem plasticItem = objectMapper.treeToValue(plasticJson, PlasticItem.class);

            // Parse genres
            List<Integer> idGenreList = objectMapper.readValue(plasticJson.get("idGenres").traverse(), new TypeReference<>() {});
            List<Genre> genreList = genreRepository.findAllById(idGenreList);
            plasticItem.setListGenres(genreList);

            // Lấy lại entity từ DB (giữ ID cũ & ảnh cũ)
            Optional<PlasticItem> existingOpt = plasticItemReposiroty.findById(plasticItem.getIdPlasticItem());
            if (existingOpt.isEmpty()) return ResponseEntity.notFound().build();
            PlasticItem existing = existingOpt.get();

            // Xóa ảnh cũ
            imageRepository.deleteAllByPlasticItem(existing);

            // Parse ảnh mới
            String thumbnailUrl = plasticJson.get("thumbnail").asText();
            List<String> relatedImgUrls = objectMapper.readValue(plasticJson.get("relatedImg").traverse(), new TypeReference<>() {});

            List<Image> newImages = new ArrayList<>();

            Image thumbnail = new Image();
            thumbnail.setPlasticItem(existing);
            thumbnail.setThumbnail(true);
            thumbnail.setUrlImage(thumbnailUrl);
            newImages.add(thumbnail);

            for (String url : relatedImgUrls) {
                Image img = new Image();
                img.setPlasticItem(existing);
                img.setThumbnail(false);
                img.setUrlImage(url);
                newImages.add(img);
            }

            // Gán lại danh sách ảnh và genres
            existing.setListImages(newImages);
            existing.setListGenres(genreList);

            // Gán các thông tin cập nhật
            existing.setNamePlasticItem(plasticItem.getNamePlasticItem());
            existing.setManufacturer(plasticItem.getManufacturer());
            existing.setDescription(plasticItem.getDescription());
            existing.setListPrice(plasticItem.getListPrice());
            existing.setSellPrice(plasticItem.getSellPrice());
            existing.setQuantity(plasticItem.getQuantity());
            existing.setAvgRating(plasticItem.getAvgRating());
            existing.setSoldQuantity(plasticItem.getSoldQuantity());
            existing.setDiscountPercent(plasticItem.getDiscountPercent());

            // Lưu
            plasticItemReposiroty.save(existing);

            return ResponseEntity.ok("Cập nhật plastic thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Lỗi khi cập nhật plastic: " + e.getMessage());
        }
    }


    @Override
    public long getTotalPlastic() {
        return plasticItemReposiroty.count();
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(plasticItemReposiroty.findAll());
    }
    private String formatStringByJson(String json) {
        return json.replaceAll("\"", "");
    }
}
