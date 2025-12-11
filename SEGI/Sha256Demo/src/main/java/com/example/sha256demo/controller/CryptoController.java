package com.example.sha256demo.controller;

import com.example.sha256demo.config.RsaKeyConfig;
import com.example.sha256demo.dto.ManualDecryptRequest;
import com.example.sha256demo.service.HashService;
import com.example.sha256demo.service.RsaDecryptionService;
import com.example.sha256demo.service.RsaEncryptionService;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/crypto")
public class CryptoController {

    private final HashService hashService;
    private final RsaEncryptionService rsaEncryptionService;
    private final RsaDecryptionService rsaDecryptionService;
    private final RsaKeyConfig keyConfig;

    public CryptoController(HashService hashService,
                            RsaEncryptionService rsaEncryptionService,
                            RsaDecryptionService rsaDecryptionService,
                            RsaKeyConfig keyConfig) {

        this.hashService = hashService;
        this.rsaEncryptionService = rsaEncryptionService;
        this.rsaDecryptionService = rsaDecryptionService;
        this.keyConfig = keyConfig;
    }

    @PostMapping("/encrypt")
    public Map<String, String> encrypt(@RequestBody Map<String, String> req) {

        String text = req.get("text");
        String hash = hashService.sha256Hex(text);

        byte[] encrypted = rsaEncryptionService.encrypt(hash);

        Map<String, String> resp = new HashMap<>();
        resp.put("sha256", hash);
        resp.put("encryptedRSA", Base64.getEncoder().encodeToString(encrypted));
        resp.put("publicKey", Base64.getEncoder().encodeToString(keyConfig.getKeyPair().getPublic().getEncoded()));
        resp.put("privateKey", Base64.getEncoder().encodeToString(keyConfig.getKeyPair().getPrivate().getEncoded()));

        return resp;
    }

    @PostMapping("/decrypt")
    public Map<String, String> decrypt(@RequestBody Map<String, String> req) {

        String encryptedBase64 = req.get("encryptedData");
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedBase64);

        String recovered = rsaDecryptionService.decrypt(encryptedBytes);

        Map<String, String> resp = new HashMap<>();
        resp.put("recoveredSha256", recovered);

        return resp;
    }

    @PostMapping("/decrypt/manual")
    public Map<String, String> decryptManual(@RequestBody ManualDecryptRequest req) {

        byte[] encryptedBytes = Base64.getDecoder().decode(req.getEncryptedDataBase64());

        String recovered = rsaDecryptionService.decryptWithProvidedPrivateKey(
                encryptedBytes,
                req.getPrivateKeyBase64()
        );

        Map<String, String> resp = new HashMap<>();
        resp.put("recoveredSha256", recovered);

        return resp;
    }
}
