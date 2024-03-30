package com.artico.artico.service;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class EncryptionService {

    @Value("${encryption.salt.rounds}")
    public int saltRound;
    private String salt;

    @PostConstruct
    public void postConstruct() {
        salt = BCrypt.gensalt(saltRound);
    }

    public String encryptPassword(String password){
        return BCrypt.hashpw(password,salt);
    }


    public static boolean verifyPassword(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }

}
