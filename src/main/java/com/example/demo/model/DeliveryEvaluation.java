package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "delivery_evaluations")
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private SLARequirement slaRequirement;

    private Integer actualDeliveryDays;
    private Double qualityScore;

    private Boolean meetsDeliveryTarget;
    private Boolean meetsQualityTarget;

    @Temporal(TemporalType.DATE)
    private Date evaluationDate = new Date();

    // getters & setters
    public Long getId() { return id; }
    public Vendor getVendor() { return vendor; }
    public SLARequirement getSlaRequirement() { return slaRequirement; }

    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public void setSlaRequirement(SLARequirement slaRequirement) { this.slaRequirement = slaRequirement; }
    public void setActualDeliveryDays(Integer actualDeliveryDays) { this.actualDeliveryDays = actualDeliveryDays; }
    public void setQualityScore(Double qualityScore) { this.qualityScore = qualityScore; }
    public void setMeetsDeliveryTarget(Boolean meetsDeliveryTarget) { this.meetsDeliveryTarget = meetsDeliveryTarget; }
    public void setMeetsQualityTarget(Boolean meetsQualityTarget) { this.meetsQualityTarget = meetsQualityTarget; }
}
