package sn.alien.sseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import sn.alien.sseapp.classses.Assurance;
import sn.alien.sseapp.classses.Medecin;
import sn.alien.sseapp.classses.User;
import sn.alien.sseapp.dao.AssuranceRepository;
import sn.alien.sseapp.dao.MedcinRepository;
import sn.alien.sseapp.dao.UserRepository;
import sn.alien.sseapp.metier.Imetier;

import java.util.concurrent.Executor;


@SpringBootApplication

public class SseappApplication implements CommandLineRunner {

    @Autowired
    private Imetier metier;

    @Autowired
    private MedcinRepository medcinRepository;

    @Autowired
    private AssuranceRepository assuranceRepository;




    @Autowired

    private UserRepository userRepository;

    public static void main(String[] args) {

        SpringApplication.run(SseappApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {



    }

}
