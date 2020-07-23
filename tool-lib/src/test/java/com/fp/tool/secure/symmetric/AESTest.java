package com.fp.tool.secure.symmetric;

import com.fp.tool.secure.Mode;
import com.fp.tool.secure.Padding;
import com.fp.tool.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author wcy
 */
@Slf4j
class AESTest {
    String key = "1234567812345678";

    String content = "hello";

    @Test
    void testAesEcb() {
        AES aes = new AES(Mode.ECB, Padding.PKCS5, key);
        assertAes(aes);
    }

    private void assertAes(AES aes) {
        byte[] encryptResult = aes.encrypt(content);
        log.debug("加密后的byte[]结果：{}", encryptResult);
        String base64Encode = aes.encryptBase64(content);
        log.debug("加密后的String结果：{}", base64Encode);


        String decryptFirst = aes.decryptStr(encryptResult);
        String decryptSecond = aes.decryptStr(encryptResult);
        log.info("first = {}, second = {}", decryptFirst, decryptSecond);

        assertNotNull(decryptFirst);
        assertNotNull(decryptSecond);
        assertEquals(decryptFirst, decryptSecond);
        assertEquals(decryptFirst, content);
    }

    @Test
    void testAESCbcIv() {
        String iv = "1201230125462244";
        AES aes = new AES(Mode.CBC, Padding.PKCS5, key, iv);
        Map<String, String> data = new HashMap<>();
        data.put("name", "lao wang");
        String json = JsonUtils.toJson(data);
        String jsonEncrypt = aes.encryptBase64(json);
        log.info(">>>>>>>>>>>>>>>>>>>>>>{}", jsonEncrypt);
        log.info(">>>>>>>>>>>>>>>>>>>>>>{}", aes.decryptStr(Base64.getDecoder().decode(jsonEncrypt)));
        aes.decryptStr(Base64.getDecoder().decode(jsonEncrypt));
        assertAes(aes);
    }
}