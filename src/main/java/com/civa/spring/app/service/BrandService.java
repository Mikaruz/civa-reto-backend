package com.civa.spring.app.service;

import com.civa.spring.app.dto.BrandRequestDTO;
import com.civa.spring.app.model.Brand;
import com.civa.spring.app.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand createBrand(BrandRequestDTO brandRequestDTO) {
        Brand brand = new Brand();
        brand.setName(brandRequestDTO.getName());

        return brandRepository.save(brand);
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Long id) {
        Optional<Brand> brand = brandRepository.findById(id);

        return brand.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca de bus no encontrada"));
    }

    public Brand updateBrand(Long id, BrandRequestDTO brandRequestDTO) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca de bus no encontrada"));

        brand.setName(brandRequestDTO.getName());
        return brandRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca de bus no encontrada");
        }
        brandRepository.deleteById(id);
    }
}
