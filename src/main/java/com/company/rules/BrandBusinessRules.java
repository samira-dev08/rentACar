package com.company.rules;

import com.company.core.utilities.exceptions.BusinessException;
import com.company.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
    if (brandRepository.existsByName(name)){
        throw new BusinessException("Brand already exists!");
    }

    }
}
