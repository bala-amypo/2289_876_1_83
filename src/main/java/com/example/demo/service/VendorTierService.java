package com.example.demo.service;

import com.example.demo.model.VendorTier;

import java.util.List;

public interface VendorTierService {

    VendorTier create(VendorTier tier);
    VendorTier update(Long id, VendorTier tier);
    VendorTier get(Long id);
    List<VendorTier> getAll();
    VendorTier deactivate(Long id);
}
