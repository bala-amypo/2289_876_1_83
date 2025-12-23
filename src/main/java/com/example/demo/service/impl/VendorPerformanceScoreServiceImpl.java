package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.VendorPerformanceScoreService;

import java.util.List;

public class VendorPerformanceScoreServiceImpl implements VendorPerformanceScoreService {

    private final VendorPerformanceScoreRepository scoreRepo;
    private final DeliveryEvaluationRepository evalRepo;
    private final VendorRepository vendorRepo;

    public VendorPerformanceScoreServiceImpl(
            VendorPerformanceScoreRepository scoreRepo,
            DeliveryEvaluationRepository evalRepo,
            VendorRepository vendorRepo,
            VendorTierRepository tierRepo) {
        this.scoreRepo = scoreRepo;
        this.evalRepo = evalRepo;
        this.vendorRepo = vendorRepo;
    }

    public VendorPerformanceScore calculateScore(Long vendorId) {
        Vendor vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        List<DeliveryEvaluation> evals = evalRepo.findByVendorId(vendorId);

        long total = evals.size();
        long onTime = evals.stream().filter(DeliveryEvaluation::getMeetsDeliveryTarget).count();
        long quality = evals.stream().filter(DeliveryEvaluation::getMeetsQualityTarget).count();

        double onTimePct = total == 0 ? 0 : (onTime * 100.0) / total;
        double qualityPct = total == 0 ? 0 : (quality * 100.0) / total;

        VendorPerformanceScore score = new VendorPerformanceScore();
        score.setVendor(vendor);
        score.setOnTimePercentage(onTimePct);
        score.setQualityCompliancePercentage(qualityPct);
        score.setOverallScore((onTimePct + qualityPct) / 2);

        return scoreRepo.save(score);
    }

    public VendorPerformanceScore getLatestScore(Long vendorId) {
        return scoreRepo.findByVendorOrderByCalculatedAtDesc(vendorId).get(0);
    }

    public List<VendorPerformanceScore> getScoresForVendor(Long vendorId) {
        return scoreRepo.findByVendorOrderByCalculatedAtDesc(vendorId);
    }
}
