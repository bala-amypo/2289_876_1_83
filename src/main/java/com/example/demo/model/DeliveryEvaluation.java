package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int actualDeliveryDays;
    private int qualityScore;
    private boolean meetsDeliveryTarget;
    private boolean meetsQualityTarget;

    public int getActualDeliveryDays() {
        return actualDeliveryDays;
    }

    public int getQualityScore() {
        return qualityScore;
    }
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DeliveryEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Vendor reference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    // 🔗 SLA requirement reference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sla_requirement_id", nullable = false)
    private SLARequirement slaRequirement;

    // 📦 Evaluation data
    private int actualDeliveryDays;
    private int qualityScore;

    private boolean meetsDeliveryTarget;
    private boolean meetsQualityTarget;

    /* ================= GETTERS ================= */

    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public SLARequirement getSlaRequirement() {
        return slaRequirement;
    }

    public int getActualDeliveryDays() {
        return actualDeliveryDays;
    }

    public int getQualityScore() {
        return qualityScore;
    }

    public boolean getMeetsDeliveryTarget() {
        return meetsDeliveryTarget;
    }

    public boolean getMeetsQualityTarget() {
        return meetsQualityTarget;
    }

    /* ================= SETTERS ================= */

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setSlaRequirement(SLARequirement slaRequirement) {
        this.slaRequirement = slaRequirement;
    }

    public void setActualDeliveryDays(int actualDeliveryDays) {
        this.actualDeliveryDays = actualDeliveryDays;
    }

    public void setQualityScore(int qualityScore) {
        this.qualityScore = qualityScore;
    }

    public void setMeetsDeliveryTarget(boolean meetsDeliveryTarget) {
        this.meetsDeliveryTarget = meetsDeliveryTarget;
    }

    public void setMeetsQualityTarget(boolean meetsQualityTarget) {
        this.meetsQualityTarget = meetsQualityTarget;
    }
}

    public boolean getMeetsDeliveryTarget() {
        return meetsDeliveryTarget;
    }

    public boolean getMeetsQualityTarget() {
        return meetsQualityTarget;
    }
}
