package com.example.demo.service.impl;

import com.example.demo.model.SLARequirement;
import com.example.demo.repository.SLARequirementRepository;
import com.example.demo.service.SLARequirementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SLARequirementServiceImpl implements SLARequirementService {

    private final SLARequirementRepository repository;

    public SLARequirementServiceImpl(SLARequirementRepository repository) {
        this.repository = repository;
    }

    @Override
    public SLARequirement create(SLARequirement req) {

        repository.findByRequirementName(req.getRequirementName())
                .ifPresent(r -> {
                    throw new IllegalArgumentException("Requirement name must be unique");
                });

        if (req.getMaxDeliveryDays() <= 0) {
            throw new IllegalArgumentException("Max delivery days must be > 0");
        }

        if (req.getMinQualityScore() < 0 || req.getMinQualityScore() > 100) {
            throw new IllegalArgumentException("Quality score must be between 0 and 100");
        }

        req.setActive(true);
        return repository.save(req);
    }

    @Override
    public SLARequirement update(Long id, SLARequirement updated) {

        SLARequirement existing = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Requirement not found"));

        existing.setDescription(updated.getDescription());
        existing.setMaxDeliveryDays(updated.getMaxDeliveryDays());
        existing.setMinQualityScore(updated.getMinQualityScore());

        return repository.save(existing);
    }

    @Override
    public SLARequirement getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Requirement not found"));
    }

    @Override
    public List<SLARequirement> getAll() {
        return repository.findAll();
    }

    @Override
    public SLARequirement deactivate(Long id) {
        SLARequirement req = getById(id);
        req.setActive(false);
        return repository.save(req);
    }
}
