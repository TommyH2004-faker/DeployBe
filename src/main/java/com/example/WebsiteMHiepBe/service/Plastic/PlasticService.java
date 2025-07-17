package com.example.WebsiteMHiepBe.service.Plastic;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

public interface PlasticService {
    public ResponseEntity<?> save (JsonNode plasticJson);
    public ResponseEntity<?> update (JsonNode plasticJson);
    public long getTotalPlastic();
    ResponseEntity<?> getAll();
}
