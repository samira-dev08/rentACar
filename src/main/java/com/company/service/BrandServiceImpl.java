package com.company.service;

import com.company.core.utilities.mappers.ModelMapperService;
import com.company.dto.request.BrandRequest;
import com.company.dto.response.BrandResponse;
import com.company.entity.Brand;
import com.company.repository.BrandRepository;
import com.company.rules.BrandBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules brandBusinessRules;


    @Override
    public List<BrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        /*List<BrandResponse> brandResponseList = new ArrayList<>();
        for (Brand brand : brands) {
            BrandResponse responseItem = new BrandResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            responseItem.setDescription(brand.getDescription());
            brandResponseList.add(responseItem);
        }*/
        List<BrandResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, BrandResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public BrandResponse getById(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow();// repoda elave ozumuz yazmamisiq deye
        BrandResponse response = modelMapperService.forResponse()
                .map(brand, BrandResponse.class);
        return response;
    }

    @Override
    public void add(BrandRequest brandRequest) {
//        Brand brand=new Brand();
//        brand.setName(brandRequest.getName());
        brandBusinessRules.checkIfBrandNameExists(brandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(brandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void update(BrandRequest brandRequest) {
        Brand brand = this.modelMapperService.forRequest()
                .map(brandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }
}
