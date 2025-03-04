package csf.server.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import csf.server.models.City;

@Repository
public class CitiesRepository {
    
    private static final String SELECT_ALL_CITIES = 
        "SELECT code, city_name FROM cities";
    
    @Autowired
    private JdbcTemplate template;

    public List<City> getAllCities() {
        return template.query(SELECT_ALL_CITIES, 
            (rs, rowNum) -> {
                System.out.println("Row #: " + rowNum);
                return City.populate(rs);
            });
    }
}
