package com.example.theatre.service;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author Shicheng Fang
 *
 * Encrption and decryption
 *
 * */
@Service
class EncryptionService {

    public String encode(String rawPassword) {
        return DigestUtils.sha256Hex(rawPassword);
    }


    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        return DigestUtils.sha256Hex(rawPassword).equals(encodedPassword);
    }
}
