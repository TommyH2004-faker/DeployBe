package com.example.WebsiteMHiepBe.Controller;

import com.example.WebsiteMHiepBe.service.UploadImage.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plastics")
@RequiredArgsConstructor
public class UploadImageController {

    private final UploadImageService uploadImageService;

    @PostMapping("/upload-images")
    public ResponseEntity<?> uploadImages(
            @RequestPart(value = "thumbnail", required = false) MultipartFile thumbnail,
            @RequestPart(value = "relatedImg", required = false) List<MultipartFile> relatedImgs) {

        Map<String, Object> result = new HashMap<>();

        if (thumbnail != null) {
            String url = uploadImageService.uploadImage(thumbnail, generateFileName(thumbnail));
            result.put("thumbnail", url);
        }

        if (relatedImgs != null && !relatedImgs.isEmpty()) {
            List<String> urls = relatedImgs.stream()
                    .map(file -> uploadImageService.uploadImage(file, generateFileName(file)))
                    .collect(Collectors.toList());
            result.put("relatedImg", urls);
        }

        return ResponseEntity.ok(result);
    }

    private String generateFileName(MultipartFile file) {
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        return "ImagePlastic/" + UUID.randomUUID() + ext;
    }
}

