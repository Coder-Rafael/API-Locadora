package com.apiLocadora.APILocadora.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiLocadora.APILocadora.DTO.CarRegisterDTO;
import com.apiLocadora.APILocadora.DTO.ListCarsDTO;
import com.apiLocadora.APILocadora.Models.CarModel;
import com.apiLocadora.APILocadora.Services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
    
    @Autowired
    CarService service;

    @GetMapping("/search/{nome}")
    public Page<ListCarsDTO> searchCar(@PathVariable String nome, Pageable pageable){
        return service.searchCarsPageable(nome, pageable);
    }

    @GetMapping("/listCars")
    public Page<ListCarsDTO> listCars(Pageable pageable){
        return service.listCarsPageable(pageable);
    }

    @PostMapping("/register")
    public CarModel registerCars(@RequestBody CarRegisterDTO car){
        return service.saveCar(car);  
    }
}
