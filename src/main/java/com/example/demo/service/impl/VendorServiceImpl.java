package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;

import java.util.List;

public class VendorServiceImpl implements VendorService {

    private final VendorRepository repo;

    public VendorServiceImpl(VendorRepository repo) {
        this.repo = repo;
    }

    public Vendor createVendor(Vendor vendor) {
        if (repo.existsByName(vendor.getName())) {
            throw new IllegalArgumentException("Vendor name must be unique");
        }
        vendor.setActive(true);
        return repo.save(vendor);
    }

    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor existing = getVendorById(id);
        existing.setName(vendor.getName());
        return repo.save(existing);
    }

    public Vendor getVendorById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
    }

    public List<Vendor> getAllVendors() {
        return repo.findAll();
    }

    public void deactivateVendor(Long id) {
        Vendor v = getVendorById(id);
        v.setActive(false);
        repo.save(v);
    }
}
