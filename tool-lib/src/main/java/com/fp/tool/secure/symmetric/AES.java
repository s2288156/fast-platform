package com.fp.tool.secure.symmetric;

import com.fp.tool.secure.AlgorithmEnum;
import com.fp.tool.secure.Mode;
import com.fp.tool.secure.Padding;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author wcy
 */
@Slf4j
public class AES extends SymmetricCrypto {

    /**
     * @param mode    模式
     * @param padding 补码方式
     * @param key     秘钥，长度必须类16,24,32
     */
    public AES(Mode mode, Padding padding, String key) {
        super(StringUtils.joinWith("/", AlgorithmEnum.AES, mode, padding.getValue()), getSecretKeySpec(key));
    }

    /**
     * @param mode    模式
     * @param padding 补码方式
     * @param key     秘钥，长度必须类16,24,32
     * @param iv      偏移量，长度必须为16
     */
    public AES(Mode mode, Padding padding, String key, String iv) {
        super(StringUtils.joinWith("/", AlgorithmEnum.AES, mode, padding.getValue()), getSecretKeySpec(key), new IvParameterSpec(iv.getBytes()));
    }

    /**
     * @param key key长度必须位16,24,32
     */
    private static SecretKeySpec getSecretKeySpec(final String key) {
        try {
            log.info("key length = {}", key.length());
            return new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AlgorithmEnum.AES.name());
        } catch (Exception e) {
            log.error("getSecretKeySpec ex:", e);
            throw new IllegalStateException("getSecretKeySpec ex");
        }
    }
}
