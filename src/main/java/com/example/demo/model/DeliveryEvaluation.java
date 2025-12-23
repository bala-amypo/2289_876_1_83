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

    public boolean getMeetsDeliveryTarget() {
        return meetsDeliveryTarget;
    }

    public boolean getMeetsQualityTarget() {
        return meetsQualityTarget;
    }
}
