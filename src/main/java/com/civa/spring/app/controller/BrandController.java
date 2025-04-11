package com.civa.spring.app.controller;

import com.civa.spring.app.dto.BrandRequestDTO;
import com.civa.spring.app.model.Brand;
import com.civa.spring.app.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody BrandRequestDTO brandRequestDTO) {
        Brand createdBrand = brandService.createBrand(brandRequestDTO);

        return new ResponseEntity<>(createdBrand, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();

        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        Brand brand = brandService.getBrandById(id);

        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody BrandRequestDTO brandRequestDTO) {
        Brand updatedBrand = brandService.updateBrand(id, brandRequestDTO);

        return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
