// package com.example.demo.service.impl;

// import com.example.demo.model.*;
// import com.example.demo.repository.*;
// import com.example.demo.service.DeliveryEvaluationService;

// import java.util.List;

// public class DeliveryEvaluationServiceImpl implements DeliveryEvaluationService {

//     private final DeliveryEvaluationRepository evalRepo;
//     private final VendorRepository vendorRepo;
//     private final SLARequirementRepository slaRepo;

//     public DeliveryEvaluationServiceImpl(
//             DeliveryEvaluationRepository evalRepo,
//             VendorRepository vendorRepo,
//             SLARequirementRepository slaRepo) {
//         this.evalRepo = evalRepo;
//         this.vendorRepo = vendorRepo;
//         this.slaRepo = slaRepo;
//     }

//     public DeliveryEvaluation createEvaluation(DeliveryEvaluation e) {
//         Vendor vendor = vendorRepo.findById(e.getVendor().getId())
//                 .orElseThrow(() -> new RuntimeException("Vendor not found"));

//         if (!vendor.getActive()) {
//             throw new IllegalStateException("Only active vendors allowed");
//         }

//         SLARequirement sla = slaRepo.findById(e.getSlaRequirement().getId())
//                 .orElseThrow(() -> new RuntimeException("SLA not found"));

//         if (e.getActualDeliveryDays() < 0) {
//             throw new IllegalArgumentException(">= 0");
//         }
//         if (e.getQualityScore() < 0 || e.getQualityScore() > 100) {
//             throw new IllegalArgumentException("between 0 and 100");
//         }

//         e.setMeetsDeliveryTarget(e.getActualDeliveryDays() <= sla.getMaxDeliveryDays());
//         e.setMeetsQualityTarget(e.getQualityScore() >= sla.getMinQualityScore());

//         return evalRepo.save(e);
//     }

//     public DeliveryEvaluation getEvaluationById(Long id) {
//         return evalRepo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Evaluation not found"));
//     }

//     public List<DeliveryEvaluation> getEvaluationsForVendor(Long vendorId) {
//         return evalRepo.findByVendorId(vendorId);
//     }

//     public List<DeliveryEvaluation> getEvaluationsForRequirement(Long requirementId) {
//         return evalRepo.findBySlaRequirementId(requirementId);
//     }
// }
