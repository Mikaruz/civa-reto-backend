package com.civa.spring.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.civa.spring.app.dto.BusRequestDTO;
import com.civa.spring.app.model.Brand;
import com.civa.spring.app.model.Bus;
import com.civa.spring.app.model.BusFeature;
import com.civa.spring.app.repository.BrandRepository;
import com.civa.spring.app.repository.BusRepository;
import org.springframework.data.domain.*;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BrandRepository brandRepository;

    public Page<Bus> getBusesPaginated(int page, int take) {
        Pageable pageable = PageRequest.of(page - 1, take);
        return busRepository.findAll(pageable);
    }

    public Bus createBus(BusRequestDTO dto) {
        Brand brand = brandRepository.findById(dto.getBrandId())
                .orElseThrow(
                        () -> new EntityNotFoundException("Marca de bus no encontrado"));

        Bus bus = new Bus();

        bus.setBusNumber(dto.getBusNumber());
        bus.setLicensePlate(dto.getLicensePlate());
        bus.setBrand(brand);

        if (dto.getFeatures() != null) {
            List<BusFeature> features = dto.getFeatures().stream()
                    .map(featureDTO -> {
                        BusFeature feature = new BusFeature();

                        feature.setName(featureDTO.getName());
                        feature.setDescription(featureDTO.getDescription());
                        feature.setBus(bus);

                        return feature;
                    }).collect(Collectors.toList());

            bus.setFeatures(features);
        }

        return busRepository.save(bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Bus getBusById(Long id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bus no encontrado"));
    }

    public Bus updateBus(Long id, BusRequestDTO dto) {
        Bus bus = getBusById(id);
        Brand brand = brandRepository.findById(dto.getBrandId())
                .orElseThrow(() -> new EntityNotFoundException("Marca de bus no encontrada"));

        bus.setBusNumber(dto.getBusNumber());
        bus.setLicensePlate(dto.getLicensePlate());
        bus.setBrand(brand);

        if (dto.getFeatures() != null) {
            List<BusFeature> features = dto.getFeatures().stream()
                    .map(featureDTO -> {
                        BusFeature feature = new BusFeature();
                        feature.setDescription(featureDTO.getDescription());
                        feature.setBus(bus);
                        return feature;
                    }).collect(Collectors.toList());
            bus.setFeatures(features);
        }

        return busRepository.save(bus);
    }

    public void deleteBus(Long id) {
        if (!busRepository.existsById(id)) {
            throw new EntityNotFoundException("Bus not found with id " + id);
        }

        busRepository.deleteById(id);
    }
}
