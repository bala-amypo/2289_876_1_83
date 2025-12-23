// package com.example.demo.service.impl;

// import com.example.demo.model.VendorTier;
// import com.example.demo.repository.VendorTierRepository;
// import com.example.demo.service.VendorTierService;

// import java.util.List;

// public class VendorTierServiceImpl implements VendorTierService {

//     private final VendorTierRepository repo;

//     public VendorTierServiceImpl(VendorTierRepository repo) {
//         this.repo = repo;
//     }

//     public VendorTier createTier(VendorTier tier) {
//         if (tier.getMinScoreThreshold() < 0 || tier.getMinScoreThreshold() > 100) {
//             throw new IllegalArgumentException("0–100");
//         }
//         if (repo.existsByTierName(tier.getTierName())) {
//             throw new IllegalArgumentException("unique");
//         }
//         return repo.save(tier);
//     }

//     public VendorTier updateTier(Long id, VendorTier tier) {
//         VendorTier t = getTierById(id);
//         t.setTierName(tier.getTierName());
//         return repo.save(t);
//     }

//     public VendorTier getTierById(Long id) {
//         return repo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Tier not found"));
//     }

//     public List<VendorTier> getAllTiers() {
//         return repo.findAll();
//     }

//     public void deactivateTier(Long id) {
//         VendorTier t = getTierById(id);
//         t.setActive(false);
//         repo.save(t);
//     }
// }
