package com.apiLocadora.APILocadora.Models;

import java.util.UUID;

import com.apiLocadora.APILocadora.DTO.CarRegisterDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "CAR_MODEL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nome;
    private String descricao;
    private Double preco;
    private String image_car;
    private int ano;

    public CarModel(CarRegisterDTO dto){
    this.nome = dto.getNome();
    this.descricao = dto.getDescricao();
    this.preco = dto.getPreco();
    this.image_car = dto.getImage_car();
    this.ano = dto.getAno();
    }
}
