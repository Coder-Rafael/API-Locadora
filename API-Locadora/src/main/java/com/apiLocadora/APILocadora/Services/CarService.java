package com.apiLocadora.APILocadora.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apiLocadora.APILocadora.DTO.CarRegisterDTO;
import com.apiLocadora.APILocadora.DTO.ListCarsDTO;
import com.apiLocadora.APILocadora.Models.CarModel;
import com.apiLocadora.APILocadora.Repositories.CarRepository;


@Service
public class CarService {
    
    @Autowired
    CarRepository repository;

    public CarModel saveCar(CarRegisterDTO dto){
        CarModel car = new CarModel(dto);
        repository.save(car);
        return car;
    }

    public Page<ListCarsDTO> listCarsPageable(Pageable pageable) {
    Page<CarModel> result = repository.findAll(pageable);
    List<ListCarsDTO> listCarsDTOs = result.getContent().stream()
            .map(car -> new ListCarsDTO(car.getId(), car.getNome(), car.getPreco(), car.getImage_car()))
            .collect(Collectors.toList());
    
    return new PageImpl<>(listCarsDTOs, pageable, result.getTotalElements());
    }

    public Page<ListCarsDTO> searchCarsPageable(String nome, Pageable pageable) {
    Page<CarModel> result = repository.findByNome(nome, pageable);
    List<ListCarsDTO> listCarsDTOs = result.getContent().stream()
            .map(car -> new ListCarsDTO(car.getId(), car.getNome(), car.getPreco(), car.getImage_car()))
            .collect(Collectors.toList());
    
    return new PageImpl<>(listCarsDTOs, pageable, result.getTotalElements());
    }
}
