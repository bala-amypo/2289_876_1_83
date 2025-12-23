package com.example.demo.controller;

import com.example.demo.model.VendorTier;
import com.example.demo.service.VendorTierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiers")
public class VendorTierController {

    private final VendorTierService service;

    public VendorTierController(VendorTierService service) {
        this.service = service;
    }

    @PostMapping
    public VendorTier create(@RequestBody VendorTier tier) {
        return service.create(tier);
    }

    @PutMapping("/{id}")
    public VendorTier update(@PathVariable Long id,
                             @RequestBody VendorTier tier) {
        return service.update(id, tier);
    }

    @GetMapping("/{id}")
    public VendorTier get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<VendorTier> list() {
        return service.getAll();
    }

    @PutMapping("/{id}/deactivate")
    public VendorTier deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
