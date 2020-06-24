package com.example.demo;

import com.example.demo.repository.AppUserRepo;
import com.example.demo.repository.CarDbRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class StartUser {

    private PasswordEncoder passwordEncoder;
    private AppUserRepo appUserRepo;
    private CarDbRepo carDbRepo;

    public StartUser(PasswordEncoder passwordEncoder, AppUserRepo appUserRepo, CarDbRepo carDbRepo) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepo = appUserRepo;
        this.carDbRepo = carDbRepo;

//        AppUser appUser = new AppUser();
//        appUser.setUsername("Adrian");
//        appUser.setPassword(passwordEncoder.encode("Adrian123"));
//        appUser.setRole(AppRole.ADMIN);
//        appUser.setEnabled(true);
//        appUserRepo.save(appUser);
//
//
//        carDbRepo.save(new Car("Tesla", "S", "czarny", 2020));
    }
}
