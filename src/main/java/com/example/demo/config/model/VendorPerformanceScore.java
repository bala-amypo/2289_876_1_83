package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendor_performance_scores")
public class VendorPerformanceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @Column(nullable = false)
    private Double onTimePercentage;

    @Column(nullable = false)
    private Double qualityCompliancePercentage;

    @Column(nullable = false)
    private Double overallScore;

    @Column(nullable = false)
    private LocalDateTime calculatedAt;

    @PrePersist
    @PreUpdate
    private void validate() {
        validateRange(onTimePercentage);
        validateRange(qualityCompliancePercentage);
        validateRange(overallScore);
        calculatedAt = LocalDateTime.now();
    }

    private void validateRange(Double value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Score values must be between 0 and 100");
        }
    }

    // getters and setters
}
