package com.example.demo.service;

import com.example.demo.model.VendorPerformanceScore;
import java.util.List;

public interface VendorPerformanceScoreService {

    // Calculate and save vendor performance score
    VendorPerformanceScore calculateScore(Long vendorId);

    // Get latest calculated score for a vendor
    VendorPerformanceScore getLatestScore(Long vendorId);

    // Get all scores for a vendor (latest first)
    List<VendorPerformanceScore> getScoresForVendor(Long vendorId);
}
