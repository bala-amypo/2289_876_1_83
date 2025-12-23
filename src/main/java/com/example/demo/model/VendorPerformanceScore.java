package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "vendor_performance_score")
public class VendorPerformanceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Vendor vendor;

    private Double onTimePercentage;
    private Double qualityCompliancePercentage;
    private Double overallScore;

    private Instant calculatedAt;

    // ===== Constructors =====
    public VendorPerformanceScore() {
        this.calculatedAt = Instant.now();
    }

    // ===== Getters =====
    public Long getId() { return id; }
    public Vendor getVendor() { return vendor; }
    public Double getOnTimePercentage() { return onTimePercentage; }
    public Double getQualityCompliancePercentage() { return qualityCompliancePercentage; }
    public Double getOverallScore() { return overallScore; }
    public Instant getCalculatedAt() { return calculatedAt; }

    // ===== Setters =====
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public void setOnTimePercentage(Double onTimePercentage) { this.onTimePercentage = onTimePercentage; }
    public void setQualityCompliancePercentage(Double qualityCompliancePercentage) {
        this.qualityCompliancePercentage = qualityCompliancePercentage;
    }
    public void setOverallScore(Double overallScore) { this.overallScore = overallScore; }
}
