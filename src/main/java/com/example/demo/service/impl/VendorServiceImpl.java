package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repo;

    public VendorServiceImpl(VendorRepository repo) {
        this.repo = repo;
    }

    public Vendor create(Vendor vendor) {
        return repo.save(vendor);
    }

    public Vendor update(Long id, Vendor vendor) {
        Vendor v = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        v.setName(vendor.getName());
        v.setContactEmail(vendor.getContactEmail());
        v.setContactPhone(vendor.getContactPhone());
        v.setActive(vendor.getActive());
        return repo.save(v);
    }

    public Vendor getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<Vendor> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
