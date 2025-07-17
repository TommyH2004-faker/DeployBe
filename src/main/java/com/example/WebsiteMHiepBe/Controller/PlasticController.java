package com.example.WebsiteMHiepBe.Controller;

import com.example.WebsiteMHiepBe.service.Plastic.PlasticService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plastic")
public class PlasticController {
    @Autowired
    private PlasticService plasticService;
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return plasticService.getAll();
    }
    @PostMapping("/add-plastic")
    public ResponseEntity<?> save(@RequestBody JsonNode jsonNode) {
        try {
            return plasticService.save(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi khi thêm sản phẩm nhựa");
            return ResponseEntity.badRequest().body("Error adding plastic item: " + e.getMessage());
        }
    }
    @PutMapping("/update-plastic")
    public ResponseEntity<?> update(@RequestBody JsonNode jsonNode) {
        try {
            return plasticService.update(jsonNode);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating plastic item: " + e.getMessage());
        }
    }
    @GetMapping("/get-total")
    public Long getTotal() {
        return plasticService.getTotalPlastic();
    }
}
