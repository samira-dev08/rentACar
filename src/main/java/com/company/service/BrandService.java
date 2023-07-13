package com.company.service;

import com.company.dto.request.BrandRequest;
import com.company.dto.response.BrandResponse;
import com.company.entity.Brand;

import java.util.List;

public interface BrandService {
    List<BrandResponse> getAll();
    BrandResponse getById(Long id);
    void add(BrandRequest brandRequest);

    void update(BrandRequest brandRequest);
    void delete(Long id);


}
