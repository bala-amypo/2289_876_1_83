package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "vendor_tier",
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
    private Boolean active;

    // ===== Constructors =====
    public VendorTier() {
        this.active = true;
    }

    public VendorTier(String tierName, Double minScoreThreshold, String description) {
        this.tierName = tierName;
        this.minScoreThreshold = minScoreThreshold;
        this.description = description;
        this.active = true;
    }

    // ===== Getters & Setters =====
    public Long getId() { return id; }
    public String getTierName() { return tierName; }
    public Double getMinScoreThreshold() { return minScoreThreshold; }
    public String getDescription() { return description; }
    public Boolean getActive() { return active; }

    public void setTierName(String tierName) { this.tierName = tierName; }
    public void setMinScoreThreshold(Double minScoreThreshold) { this.minScoreThreshold = minScoreThreshold; }
    public void setDescription(String description) { this.description = description; }
    public void setActive(Boolean active) { this.active = active; }
}
