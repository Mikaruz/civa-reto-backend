package com.civa.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.civa.spring.app.dto.BusRequestDTO;
import com.civa.spring.app.dto.PaginatedResponse;
import com.civa.spring.app.model.Bus;
import com.civa.spring.app.service.BusService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody BusRequestDTO busRequestDTO) {
        Bus bus = busService.createBus(busRequestDTO);
        return new ResponseEntity<>(bus, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PaginatedResponse<Bus>> getAllBuses(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int take) {

        Page<Bus> pageResult = busService.getBusesPaginated(page, take);

        PaginatedResponse.Meta meta = new PaginatedResponse.Meta(
                page,
                take,
                (page - 1) * take,
                pageResult.getTotalElements(),
                pageResult.getTotalPages());

        PaginatedResponse<Bus> response = new PaginatedResponse<>(pageResult.getContent(), meta);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        return new ResponseEntity<>(busService.getBusById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody BusRequestDTO busRequestDTO) {
        return new ResponseEntity<>(busService.updateBus(id, busRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
