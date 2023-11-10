package com.apiLocadora.APILocadora.DTO;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCarsDTO {
    
    private UUID id;
    private String nome;
    private Double preco;
    private String image_car;
}
