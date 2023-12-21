package com.diouf.gmail.parrainage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.diouf.gmail.parrainage.entites.Administrateur;
import com.diouf.gmail.parrainage.repositories.AdminRepository;


@Component
public class AlloDocteurConfig implements CommandLineRunner {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Demarrage de l'application");
        if (adminRepository.count() == 0) {
            System.out.println("Pas d'administrateur dans le système");
            System.out.println("Création de l'utilisateur administrateur");

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

             String rawPassword = "admin"; // Remplacez par le mot de passe réel
            Administrateur admin = new Administrateur();
            String hashedPassword = passwordEncoder.encode(rawPassword);
            admin.setNom("Diouf");
            admin.setAdresse("Thies");
            admin.setAge(22);
            admin.setPrenom("Serigne Mor");
            admin.setSexe("M");
            admin.setContact("778653628");
            admin.setPassword(hashedPassword);
            admin.setEmail("admin@gmail.com");

            // Associez le compte à l'administrateur
          

            // Persistez l'administrateur
            adminRepository.save(admin);

            System.out.println("Enregistrement de l'administrateur " + admin);
        }
    }
}
