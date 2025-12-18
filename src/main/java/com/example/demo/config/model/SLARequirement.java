package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "sla_requirements",
    uniqueConstraints = @UniqueConstraint(columnNames = "requirementName")
)
public class SLARequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String requirementName;

    private String description;

    @Column(nullable = false)
    private Integer maxDeliveryDays;

    @Column(nullable = false)
    private Double minQualityScore;

    @Column(nullable = false)
    private Boolean active = true;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (maxDeliveryDays <= 0) {
            throw new IllegalArgumentException("maxDeliveryDays must be > 0");
        }
        if (minQualityScore < 0 || minQualityScore > 100) {
            throw new IllegalArgumentException("minQualityScore must be between 0 and 100");
        }
    }

    // getters and setters
}
