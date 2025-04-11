package com.civa.spring.app.dto;

import java.util.List;

public class BusRequestDTO {

    private String busNumber;
    private String licensePlate;
    private Long brandId;
    private List<BusFeatureRequestDTO> features;

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public List<BusFeatureRequestDTO> getFeatures() {
        return features;
    }

    public void setFeatures(List<BusFeatureRequestDTO> features) {
        this.features = features;
    }
}
