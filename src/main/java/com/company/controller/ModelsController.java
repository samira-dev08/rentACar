package com.company.controller;

import com.company.dto.request.BrandRequest;
import com.company.dto.request.ModelRequest;
import com.company.dto.response.BrandResponse;
import com.company.dto.response.ModelResponse;
import com.company.service.ModelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private final ModelService modelService;
    @GetMapping
    public List<ModelResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid ModelRequest modelRequest) {
        modelService.add(modelRequest);
    }
    @PutMapping
    public void update(@RequestBody @Valid ModelRequest modelRequest) {
        modelService.update(modelRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Long id) {
        modelService.delete(id);
    }
}
