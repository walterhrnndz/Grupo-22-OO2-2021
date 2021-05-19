package com.unla.oo22021;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerateEncryptedPassword {
    public static void main(String[] args) {
        BCryptPasswordEncoder pass = new BCryptPasswordEncoder();

        System.out.println(pass.encode("walter"));
    }
}