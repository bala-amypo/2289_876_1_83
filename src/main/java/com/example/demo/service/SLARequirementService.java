package com.example.demo.service;

import com.example.demo.model.SLARequirement;
import java.util.List;

public interface SLARequirementService {

    SLARequirement create(SLARequirement requirement);
    SLARequirement update(Long id, SLARequirement requirement);
    SLARequirement getById(Long id);
    List<SLARequirement> getAll();
    SLARequirement deactivate(Long id);
}
