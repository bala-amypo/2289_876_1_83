package com.example.vendor.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class VendorPerformanceScoreController {

    
    /**
     * Calculate score for a vendor
     */
    @PostMapping("/calculate/{vendorId}")
    public String calculateScore(
            @PathVariable Long vendorId) {

        // VendorPerformanceScoreDto score =
        //         vendorPerformanceScoreService.calculateScore(vendorId);
        return "vendorId: "+ vendorId;
    }

    /**
     * Get latest score for a vendor
     */
    @GetMapping("/latest/{vendorId}")
    public String getLatestScore(
            @PathVariable Long vendorId) {

        // VendorPerformanceScoreDto latestScore =
        //         vendorPerformanceScoreService.getLatestScore(vendorId);
        return "vendorId: "+ vendorId;
    }

    /**
     * Get score history for a vendor
     */
    @GetMapping("/vendor/{vendorId}")
    public String getScoreHistory(
            @PathVariable Long vendorId) {

        // List<VendorPerformanceScoreDto> scores =
        //         vendorPerformanceScoreService.getScoreHistory(vendorId);
        return "vendorId: "+ vendorId;
    }
}