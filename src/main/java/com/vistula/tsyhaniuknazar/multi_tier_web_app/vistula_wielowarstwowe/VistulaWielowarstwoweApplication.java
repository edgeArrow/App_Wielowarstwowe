package com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VistulaWielowarstwoweApplication {

    public static void main(String[] args) {
        SpringApplication.run(VistulaWielowarstwoweApplication.class, args);
    }


    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}
