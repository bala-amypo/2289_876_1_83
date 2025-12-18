package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "vendor_tiers",
    uniqueConstraints = @UniqueConstraint(columnNames = "tierName")
)
public class VendorTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tierName;

    @Column(nullable = false)
    private Double minScoreThreshold;

    private String description;

    @Column(nullable = false)
    private Boolean active = true;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (minScoreThreshold < 0 || minScoreThreshold > 100) {
            throw new IllegalArgumentException("minScoreThreshold must be between 0 and 100");
        }
    }

    // getters and setters
}
