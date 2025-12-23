package com.example.demo.service;

import com.example.demo.model.DeliveryEvaluation;
import java.util.List;

public interface DeliveryEvaluationService {

    DeliveryEvaluation create(DeliveryEvaluation evaluation);
    DeliveryEvaluation getById(Long id);
    List<DeliveryEvaluation> getByVendor(Long vendorId);
    List<DeliveryEvaluation> getByRequirement(Long reqId);
}
