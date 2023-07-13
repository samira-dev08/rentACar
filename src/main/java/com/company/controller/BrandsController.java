package com.company.controller;

import com.company.dto.request.BrandRequest;
import com.company.dto.response.BrandResponse;
import com.company.service.BrandService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;
    @GetMapping
    public List<BrandResponse> getAll() {
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    public BrandResponse getById(@PathVariable  Long id) {
        return brandService.getById(id);
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid BrandRequest brandRequest) {
         brandService.add(brandRequest);
    }
    @PutMapping
    public void update(@RequestBody @Valid BrandRequest brandRequest) {
        brandService.update(brandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Long id) {
         brandService.delete(id);
    }
}
