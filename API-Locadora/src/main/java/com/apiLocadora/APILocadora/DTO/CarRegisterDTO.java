package com.apiLocadora.APILocadora.DTO;


import org.springframework.stereotype.Service;

import com.apiLocadora.APILocadora.Models.CarModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRegisterDTO {
    
    private String nome;
    private String descricao;
    private Double preco;
    private String image_car;
    private int ano;

    public CarRegisterDTO(CarModel car){
    this.nome = car.getNome();
    this.descricao = car.getDescricao();
    this.preco = car.getPreco();
    this.image_car = car.getImage_car();
    this.ano = car.getAno();
    }

}
