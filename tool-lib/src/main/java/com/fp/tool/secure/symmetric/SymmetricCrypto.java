package com.fp.tool.secure.symmetric;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对称加密
 *
 * @author wcy
 */
public class SymmetricCrypto {

    private Cipher cipher;

    private SecretKey secretKey;

    private AlgorithmParameterSpec parameterSpec;

    private final Lock lock = new ReentrantLock();

    public SymmetricCrypto(String algorithm, SecretKey secretKey, AlgorithmParameterSpec parameterSpec) {
        try {
            this.cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            throw new IllegalStateException("cipher.getInstance error:", e);
        }
        this.secretKey = secretKey;
        this.parameterSpec = parameterSpec;
    }
}
