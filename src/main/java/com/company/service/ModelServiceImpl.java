package com.company.service;

import com.company.core.utilities.mappers.ModelMapperService;
import com.company.dto.request.ModelRequest;
import com.company.dto.response.BrandResponse;
import com.company.dto.response.ModelResponse;
import com.company.entity.Brand;
import com.company.entity.Model;
import com.company.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<ModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<ModelResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, ModelResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(ModelRequest modelRequest) {
        Model model = this.modelMapperService.forRequest().map(modelRequest, Model.class);
        modelRepository.save(model);
    }

    @Override
    public void update(ModelRequest modelRequest) {
        Model model = this.modelMapperService.forRequest()
                .map(modelRequest, Model.class);
        modelRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        modelRepository.deleteById(id);

    }
}
