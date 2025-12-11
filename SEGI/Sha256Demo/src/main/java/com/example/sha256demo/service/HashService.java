package com.example.sha256demo.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class HashService {

    /**
     * Gera SHA-256 hex a partir do texto.
     * Usa Apache Commons Codec DigestUtils.sha256Hex que internamente:
     *  - converte string para bytes (UTF-8)
     *  - aplica MessageDigest SHA-256
     *  - transforma o resultado em hex
     */
    public String sha256Hex(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Texto não deve ser vazio.");
        }
        return DigestUtils.sha256Hex(input);
    }
}
