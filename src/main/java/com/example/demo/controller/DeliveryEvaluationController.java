package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery_evaluations")
public class DeliveryEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;
    
    @ManyToOne
    @JoinColumn(name = "sla_requirement_id")
    private SLARequirement slaRequirement;
    
    private Integer actualDeliveryDays;
    private Double qualityScore;
    private LocalDate evaluationDate;
    private Boolean meetsDeliveryTarget;
    private Boolean meetsQualityTarget;
    
    public DeliveryEvaluation() {}
    
    public DeliveryEvaluation(Vendor vendor, SLARequirement slaRequirement, Integer actualDeliveryDays, Double qualityScore, LocalDate evaluationDate) {
        this.vendor = vendor;
        this.slaRequirement = slaRequirement;
        this.actualDeliveryDays = actualDeliveryDays;
        this.qualityScore = qualityScore;
        this.evaluationDate = evaluationDate;
        this.meetsDeliveryTarget = actualDeliveryDays <= slaRequirement.getMaxDeliveryDays();
        this.meetsQualityTarget = qualityScore >= slaRequirement.getMinQualityScore();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    
    public SLARequirement getSlaRequirement() { return slaRequirement; }
    public void setSlaRequirement(SLARequirement slaRequirement) { this.slaRequirement = slaRequirement; }
    
    public Integer getActualDeliveryDays() { return actualDeliveryDays; }
    public void setActualDeliveryDays(Integer actualDeliveryDays) { this.actualDeliveryDays = actualDeliveryDays; }
    
    public Double getQualityScore() { return qualityScore; }
    public void setQualityScore(Double qualityScore) { this.qualityScore = qualityScore; }
    
    public LocalDate getEvaluationDate() { return evaluationDate; }
    public void setEvaluationDate(LocalDate evaluationDate) { this.evaluationDate = evaluationDate; }
    
    public Boolean getMeetsDeliveryTarget() { return meetsDeliveryTarget; }
    public void setMeetsDeliveryTarget(Boolean meetsDeliveryTarget) { this.meetsDeliveryTarget = meetsDeliveryTarget; }
    
    public Boolean getMeetsQualityTarget() { return meetsQualityTarget; }
    public void setMeetsQualityTarget(Boolean meetsQualityTarget) { this.meetsQualityTarget = meetsQualityTarget; }
}package com.example.demo.controller;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.service.DeliveryEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-evaluations")
@Tag(name = "Delivery Evaluations", description = "APIs for managing delivery evaluations")
public class DeliveryEvaluationController {

    @Autowired
    private DeliveryEvaluationService service;

    @PostMapping
    @Operation(summary = "Create delivery evaluation")
    public ResponseEntity<DeliveryEvaluation> createEvaluation(@RequestBody DeliveryEvaluation evaluation) {
        return ResponseEntity.ok(service.createEvaluation(evaluation));
    }

    @GetMapping("/vendor/{vendorId}")
    @Operation(summary = "Get evaluations by vendor")
    public ResponseEntity<List<DeliveryEvaluation>> getByVendor(@PathVariable Long vendorId) {
        return ResponseEntity.ok(service.getEvaluationsForVendor(vendorId));
    }

    @GetMapping("/requirement/{requirementId}")
    @Operation(summary = "Get evaluations by requirement")
    public ResponseEntity<List<DeliveryEvaluation>> getByRequirement(@PathVariable Long requirementId) {
        return ResponseEntity.ok(service.getEvaluationsForRequirement(requirementId));
    }
}