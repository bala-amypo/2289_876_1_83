package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery_evaluations")
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sla_requirement_id")
    private SLARequirement slaRequirement;

    @Column(nullable = false)
    private Integer actualDeliveryDays;

    @Column(nullable = false)
    private Double qualityScore;

    @Column(nullable = false)
    private LocalDate evaluationDate;

    @Column(nullable = false)
    private Boolean meetsDeliveryTarget;

    @Column(nullable = false)
    private Boolean meetsQualityTarget;

    @PrePersist
    @PreUpdate
    private void evaluate() {
        if (actualDeliveryDays < 0) {
            throw new IllegalArgumentException("actualDeliveryDays must be >= 0");
        }
        if (qualityScore < 0 || qualityScore > 100) {
            throw new IllegalArgumentException("qualityScore must be between 0 and 100");
        }

        meetsDeliveryTarget =
                actualDeliveryDays <= slaRequirement.getMaxDeliveryDays();

        meetsQualityTarget =
                qualityScore >= slaRequirement.getMinQualityScore();
    }

    // getters and setters
}
