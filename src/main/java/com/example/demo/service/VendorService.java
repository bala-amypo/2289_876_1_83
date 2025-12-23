package com.example.demo.service;

import com.example.demo.model.Vendor;
import java.util.List;

public interface VendorService {
    Vendor create(Vendor vendor);
    Vendor update(Long id, Vendor vendor);
    Vendor getById(Long id);
    List<Vendor> getAll();
    void delete(Long id);
}
