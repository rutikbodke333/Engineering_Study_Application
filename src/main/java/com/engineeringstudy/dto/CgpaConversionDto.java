package com.engineeringstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CgpaConversionDto {

    private Long id;
    private Double cgpa;
    private Double percentage;
}
