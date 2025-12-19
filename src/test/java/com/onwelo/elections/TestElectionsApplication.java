package com.onwelo.elections;

import org.springframework.boot.SpringApplication;

public class TestElectionsApplication {

    public static void main(String[] args) {
        SpringApplication.from(ElectionsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
