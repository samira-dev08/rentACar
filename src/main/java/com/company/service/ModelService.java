package com.company.service;

import com.company.dto.request.BrandRequest;
import com.company.dto.request.ModelRequest;
import com.company.dto.response.BrandResponse;
import com.company.dto.response.ModelResponse;

import java.util.List;

public interface ModelService {
    List<ModelResponse> getAll();
    void add(ModelRequest modelRequest);
    void update(ModelRequest modelRequest);
    void delete(Long id);
}
