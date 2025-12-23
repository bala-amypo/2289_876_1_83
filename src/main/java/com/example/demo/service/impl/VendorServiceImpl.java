package com.example.demo.service.impl;

import com.example.demo.dto.VendorDTO;
import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repository;

    public VendorServiceImpl(VendorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vendor createVendor(VendorDTO dto) {
        repository.findByName(dto.getName())
                .ifPresent(v -> {
                    throw new IllegalArgumentException("Vendor name must be unique");
                });

        Vendor vendor = new Vendor();
        vendor.setName(dto.getName());
        vendor.setContactEmail(dto.getContactEmail());
        vendor.setContactPhone(dto.getContactPhone());

        return repository.save(vendor);
    }

    @Override
    public Vendor updateVendor(Long id, VendorDTO dto) {
        Vendor vendor = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Vendor not found"));

        vendor.setContactEmail(dto.getContactEmail());
        vendor.setContactPhone(dto.getContactPhone());
        return repository.save(vendor);
    }

    @Override
    public Vendor getVendor(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Vendor not found"));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return repository.findAll();
    }

    @Override
    public Vendor deactivateVendor(Long id) {
        Vendor vendor = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Vendor not found"));

        vendor.setActive(false);
        return repository.save(vendor);
    }
}
