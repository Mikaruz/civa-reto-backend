package com.civa.spring.app.service;

import com.civa.spring.app.model.Bus;
import com.civa.spring.app.model.BusFeature;
import com.civa.spring.app.model.Brand;
import com.civa.spring.app.repository.BusRepository;
import com.civa.spring.app.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeedService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BrandRepository brandRepository;

    public String seedDatabase() {

        busRepository.deleteAll();
        brandRepository.deleteAll();

        List<String> brandNames = Arrays.asList("Volvo", "Scania", "Fiat");
        List<Brand> brands = new ArrayList<>();

        for (String name : brandNames) {
            Brand brand = new Brand();
            brand.setName(name);
            brands.add(brandRepository.save(brand));
        }

        List<String> features = Arrays.asList("WiFi", "Asientos reclinables", "TV", "Puertos USB", "Baño");
        Random random = new Random();

        for (int i = 1; i <= 100; i++) {
            Bus bus = new Bus();

            bus.setBusNumber("B-" + String.format("%03d", i));
            bus.setLicensePlate("XYZ-" + (100 + i));
            bus.setBrand(brands.get(random.nextInt(brands.size())));
            bus.setActive(true);

            Collections.shuffle(features);
            List<String> selectedFeatures = features.subList(0, 2);

            for (String featureName : selectedFeatures) {
                BusFeature feature = new BusFeature();
                feature.setName(featureName);
                feature.setDescription("Incluye: " + featureName);
                feature.setBus(bus);
                bus.getFeatures().add(feature);
            }

            busRepository.save(bus);
        }

        return "✅ Seed ejecutado correctamente. Se insertaron 100 buses con características únicas.";
    }
}
