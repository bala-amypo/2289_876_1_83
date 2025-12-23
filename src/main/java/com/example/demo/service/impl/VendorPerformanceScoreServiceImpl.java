package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.repository.VendorPerformanceScoreRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorPerformanceScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorPerformanceScoreServiceImpl
        implements VendorPerformanceScoreService {

    private static final double ON_TIME_WEIGHT = 0.6;
    private static final double QUALITY_WEIGHT = 0.4;

    private final VendorRepository vendorRepository;
    private final VendorPerformanceScoreRepository scoreRepository;

    public VendorPerformanceScoreServiceImpl(
            VendorRepository vendorRepository,
            VendorPerformanceScoreRepository scoreRepository) {
        this.vendorRepository = vendorRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public VendorPerformanceScore calculateScore(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new IllegalStateException("Vendor not found"));

        // Demo values (replace with real evaluation aggregation later)
        double onTime = 85.0;
        double quality = 90.0;

        if (onTime < 0 || onTime > 100 ||
            quality < 0 || quality > 100) {
            throw new IllegalArgumentException("Score values must be 0-100");
        }

        double overall =
                (onTime * ON_TIME_WEIGHT) +
                (quality * QUALITY_WEIGHT);

        VendorPerformanceScore score = new VendorPerformanceScore();
        score.setVendor(vendor);
        score.setOnTimePercentage(onTime);
        score.setQualityCompliancePercentage(quality);
        score.setOverallScore(overall);

        return scoreRepository.save(score);
    }

    @Override
    public VendorPerformanceScore getLatestScore(Long vendorId) {
        return scoreRepository
                .findTopByVendorIdOrderByCalculatedAtDesc(vendorId)
                .orElseThrow(() -> new IllegalStateException("Score not found"));
    }

    @Override
    public List<VendorPerformanceScore> getScoreHistory(Long vendorId) {
        return scoreRepository.findByVendorIdOrderByCalculatedAtDesc(vendorId);
    }
}
