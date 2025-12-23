package com.example.demo.repository;

import com.example.demo.model.VendorTier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorTierRepository
        extends JpaRepository<VendorTier, Long> {

    Optional<VendorTier> findByTierName(String tierName);
}
