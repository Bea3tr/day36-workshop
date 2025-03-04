package csf.server.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import csf.server.models.City;
import csf.server.services.CitiesService;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;

@Controller
@RequestMapping(path="/api")
public class CitiesController {

    @Autowired
    private CitiesService citiesSvc;

    @GetMapping(path="/cities", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllCities() {
        JsonArray result = null;

        Optional<List<City>> cities = citiesSvc.getAllCities();
        List<City> aa = cities.get();
        JsonArrayBuilder b = Json.createArrayBuilder();
        for(City c : aa) {
            b.add(c.toJson());
        }
        result = b.build();
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(result.toString());


    }
}
