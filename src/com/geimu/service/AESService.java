package com.geimu.service;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class AESService {

    private static final Base64 base64 = new Base64();
    private static final String AESKey = "b0NEJ9W2JLdZwFDlV7hv+w==";
    private static final byte[] AESKeyByteArray = base64.decode(AESKey);
    private static final SecretKeySpec spec = new SecretKeySpec(AESKeyByteArray, "AES");
    private static Cipher cipher;

    static {
        try {
            cipher = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(AESService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String Encrypt(String src) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, spec);
        byte[] encryptData = cipher.doFinal(src.getBytes("UTF-8"));
        return base64.encodeToString(encryptData);
    }

    public static String Decrypt(String src) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, spec);
        byte[] original = cipher.doFinal(base64.decode(src));
        return new String(original, "UTF-8");
    }
}
