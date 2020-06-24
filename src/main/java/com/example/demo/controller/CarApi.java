package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.repository.CarDbRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarApi {

    private CarDbRepo carList;
    private String search;

    public CarApi(CarDbRepo carList) {
        this.carList = carList;
    }



    @GetMapping
    public String getVehicles(Model model){
        model.addAttribute("cars",   carList.findAll());
        model.addAttribute("newCar", new Car());
        model.addAttribute("delCar", new Car());
        model.addAttribute("modCar", new Car());
        model.addAttribute("searchCar", new Car());

        return "vehicle";
    }


    @PostMapping("/add")
    public String addVehicle(@ModelAttribute Car car){
       try {
           carList.save(car);
       } catch (Exception e){}
       return "redirect:/";
    }


    @PostMapping("/modification")
    public String modElementVehicle(@ModelAttribute Car car){
        try {
            carList.saveAndFlush(car);
        }  catch (Exception e){}
            return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Long id){
        try {
            carList.deleteById(id);
        }  catch (Exception e){}
            return "redirect:/";
    }

}
