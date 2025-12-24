package com.example.demo.service.impl;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.model.SLARequirement;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.service.DeliveryEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

    private final DeliveryEvaluationRepository repository;

    public DeliveryEvaluationServiceImpl(DeliveryEvaluationRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryEvaluation create(DeliveryEvaluation eval) {

        if (eval.getActualDeliveryDays() < 0) {
            throw new IllegalArgumentException("Max delivery days must be >= 0");
        }

        if (eval.getQualityScore() < 0 || eval.getQualityScore() > 100) {
            throw new IllegalArgumentException("Quality score must be between 0 and 100");
        }

        SLARequirement sla = eval.getSlaRequirement();

        eval.setMeetsDeliveryTarget(
                eval.getActualDeliveryDays() <= sla.getMaxDeliveryDays()
        );

        eval.setMeetsQualityTarget(
                eval.getQualityScore() >= sla.getMinQualityScore()
        );

        return repository.save(eval);
    }

    @Override
    public DeliveryEvaluation getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Evaluation not found"));
    }

    @Override
    public List<DeliveryEvaluation> getByVendor(Long vendorId) {
        return repository.findByVendorId(vendorId);
    }

    @Override
    public List<DeliveryEvaluation> getByRequirement(Long reqId) {
        return repository.findBySlaRequirementId(reqId);
    }
}
