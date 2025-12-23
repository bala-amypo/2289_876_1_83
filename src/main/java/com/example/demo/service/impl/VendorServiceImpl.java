package com.example.demo.service.impl;

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
    public Vendor createVendor(Vendor vendor) {

        repository.findByName(vendor.getName())
                .ifPresent(v -> {
                    throw new IllegalArgumentException("Vendor name must be unique");
                });

        vendor.setActive(true);
        return repository.save(vendor);
    }

    @Override
    public Vendor updateVendor(Long id, Vendor updatedVendor) {

        Vendor existing = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Vendor not found"));

        existing.setContactEmail(updatedVendor.getContactEmail());
        existing.setContactPhone(updatedVendor.getContactPhone());

        return repository.save(existing);
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
