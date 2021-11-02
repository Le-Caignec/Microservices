package com.microservices.bdd.bdd.firebase;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitialisation {

    @PostConstruct
    public void initialisation(){
        FirebaseOptions options = null;
        try {
            FileInputStream refreshToken = new FileInputStream("token.json");

            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
