package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService service;

    public VendorController(VendorService service) {
        this.service = service;
    }

    // POST /api/vendors
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return service.createVendor(vendor);
    }

    // PUT /api/vendors/{id}
    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable Long id,
                               @RequestBody Vendor vendor) {
        return service.updateVendor(id, vendor);
    }

    // GET /api/vendors/{id}
    @GetMapping("/{id}")
    public Vendor getVendor(@PathVariable Long id) {
        return service.getVendor(id);
    }

    // GET /api/vendors
    @GetMapping
    public List<Vendor> getAllVendors() {
        return service.getAllVendors();
    }

    // PUT /api/vendors/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public Vendor deactivateVendor(@PathVariable Long id) {
        return service.deactivateVendor(id);
    }
}
