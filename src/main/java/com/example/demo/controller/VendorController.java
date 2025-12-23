package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    // Constructor injection
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // CREATE
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    // READ by ID
    @GetMapping("/{id}")
    public Vendor getVendor(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    // READ all
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Vendor updateVendor(
            @PathVariable Long id,
            @RequestBody Vendor vendor) {
        return vendorService.updateVendor(id, vendor);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
    }
}
