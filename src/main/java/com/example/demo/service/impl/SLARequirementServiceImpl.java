// package com.example.demo.service.impl;

// import com.example.demo.model.SLARequirement;
// import com.example.demo.repository.SLARequirementRepository;
// import com.example.demo.service.SLARequirementService;

// import java.util.List;

// public class SLARequirementServiceImpl implements SLARequirementService {

//     private final SLARequirementRepository repo;

//     public SLARequirementServiceImpl(SLARequirementRepository repo) {
//         this.repo = repo;
//     }

//     public SLARequirement createRequirement(SLARequirement req) {
//         if (req.getMaxDeliveryDays() <= 0) {
//             throw new IllegalArgumentException("Max delivery days must be greater than 0");
//         }
//         if (req.getMinQualityScore() < 0 || req.getMinQualityScore() > 100) {
//             throw new IllegalArgumentException("Quality score between 0 and 100");
//         }
//         if (repo.existsByRequirementName(req.getRequirementName())) {
//             throw new IllegalArgumentException("Requirement name must be unique");
//         }
//         return repo.save(req);
//     }

//     public SLARequirement updateRequirement(Long id, SLARequirement req) {
//         SLARequirement existing = getRequirementById(id);
//         existing.setRequirementName(req.getRequirementName());
//         return repo.save(existing);
//     }

//     public SLARequirement getRequirementById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("SLA requirement not found"));
//     }

//     public List<SLARequirement> getAllRequirements() {
//         return repo.findAll();
//     }

//     public void deactivateRequirement(Long id) {
//         SLARequirement req = getRequirementById(id);
//         req.setActive(false);
//         repo.save(req);
//     }
// }
