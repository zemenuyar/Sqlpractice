package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    asbezaRepository repository;

    @Override
    public void run(String... Strings) throws Exception{
        asbeza asbeza = new asbeza("Astrophysics","Neil D Tyson","Just a asbeza on stars", 3);
        asbeza = new asbeza("Calculs","Carol Henley","Rare of Change of the Rate of Change",3);
        repository.save(asbeza);

        asbeza = new asbeza("Freshman Enlish","Geraldine pegram","learn you language children",3);
        repository.save(asbeza);
    }
}
