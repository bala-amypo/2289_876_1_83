package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery_evaluation")
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Vendor vendor;

    @ManyToOne(optional = false)
    private SLARequirement slaRequirement;

    private Integer actualDeliveryDays;
    private Double qualityScore;

    private LocalDate evaluationDate;

    private Boolean meetsDeliveryTarget;
    private Boolean meetsQualityTarget;

    // ===== Constructors =====
    public DeliveryEvaluation() {
        this.evaluationDate = LocalDate.now();
    }

    // ===== Getters & Setters =====
    public Long getId() { return id; }
    public Vendor getVendor() { return vendor; }
    public SLARequirement getSlaRequirement() { return slaRequirement; }
    public Integer getActualDeliveryDays() { return actualDeliveryDays; }
    public Double getQualityScore() { return qualityScore; }
    public LocalDate getEvaluationDate() { return evaluationDate; }
    public Boolean getMeetsDeliveryTarget() { return meetsDeliveryTarget; }
    public Boolean getMeetsQualityTarget() { return meetsQualityTarget; }

    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public void setSlaRequirement(SLARequirement slaRequirement) { this.slaRequirement = slaRequirement; }
    public void setActualDeliveryDays(Integer actualDeliveryDays) { this.actualDeliveryDays = actualDeliveryDays; }
    public void setQualityScore(Double qualityScore) { this.qualityScore = qualityScore; }
    public void setMeetsDeliveryTarget(Boolean meetsDeliveryTarget) { this.meetsDeliveryTarget = meetsDeliveryTarget; }
    public void setMeetsQualityTarget(Boolean meetsQualityTarget) { this.meetsQualityTarget = meetsQualityTarget; }
}
