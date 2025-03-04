package csf.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csf.server.models.City;
import csf.server.repositories.CitiesRepository;

@Service
public class CitiesService {

    @Autowired
    private CitiesRepository citiesRepo;

    public Optional<List<City>> getAllCities() {
        List<City> cc = this.citiesRepo.getAllCities();
        if(cc != null) {
            return Optional.of(cc);
        }
        return Optional.empty();
    }
    
}
