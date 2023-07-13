package com.company.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelRequest {
    private Long modelId;
    @NotNull
    @NotBlank
    @Size(min=3,max=20)
    private String name;
    @NotNull
    @NotBlank
    private Long brandId;

}
