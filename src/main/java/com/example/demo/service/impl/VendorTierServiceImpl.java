package com.example.demo.service.impl;

import com.example.demo.model.VendorTier;
import com.example.demo.repository.VendorTierRepository;
import com.example.demo.service.VendorTierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorTierServiceImpl implements VendorTierService {

    private final VendorTierRepository repository;

    public VendorTierServiceImpl(VendorTierRepository repository) {
        this.repository = repository;
    }

    @Override
    public VendorTier create(VendorTier tier) {

        repository.findByTierName(tier.getTierName())
                .ifPresent(t -> {
                    throw new IllegalArgumentException("Tier name must be unique");
                });

        if (tier.getMinScoreThreshold() < 0 || tier.getMinScoreThreshold() > 100) {
            throw new IllegalArgumentException("Score threshold must be between 0 and 100");
        }

        tier.setActive(true);
        return repository.save(tier);
    }

    @Override
    public VendorTier update(Long id, VendorTier updated) {

        VendorTier existing = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Tier not found"));

        existing.setDescription(updated.getDescription());
        existing.setMinScoreThreshold(updated.getMinScoreThreshold());

        return repository.save(existing);
    }

    @Override
    public VendorTier get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Tier not found"));
    }

    @Override
    public List<VendorTier> getAll() {
        return repository.findAll();
    }

    @Override
    public VendorTier deactivate(Long id) {
        VendorTier tier = get(id);
        tier.setActive(false);
        return repository.save(tier);
    }
}
