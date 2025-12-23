package com.example.demo.service;

import com.example.demo.dto.VendorDTO;
import com.example.demo.model.Vendor;

import java.util.List;

public interface VendorService {

    Vendor createVendor(VendorDTO dto);
    Vendor updateVendor(Long id, VendorDTO dto);
    Vendor getVendor(Long id);
    List<Vendor> getAllVendors();
    Vendor deactivateVendor(Long id);
}
