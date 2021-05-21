package com.sjf.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESUtil {

    private static final String AES = "AES";

    /**
     * 这里是用来处理持卡人姓名、证件号等信息的密钥
     */
    //public static final String AES_KEY = "78B49F4BF5B16A17";
    public static final String AES_KEY = "00112233445566778899AABBCCDDEEFF";
    
    /**
     * 随机生成秘钥
     */
    public static String getKey() {
        return AESUtil.getKey(256);
    }

    private static String getKey(int number) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance(AES);
            kg.init(number);// 要生成多少位，只需要修改这里即可128, 192或256
            SecretKey sk = kg.generateKey();
            byte[] b = sk.getEncoded();
            return Base64.encodeBase64String(b);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("生成AES秘钥串失败", e);
        }
    }

    public static String encode(String aesKey, String plaintext) {
        try {
            // 根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(Base64.decodeBase64(aesKey), AES);
            // 根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(AES);
            // 初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.encodeBase64String(cipher.doFinal(plaintext.getBytes("UTF-8")));
        } catch (Throwable e) {
            throw new RuntimeException("AES加密失败", e);
        }
    }

    public static String decode(String aesKey, String ciphertext) {
        try {
            // 根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(Base64.decodeBase64(aesKey), AES);
            // 根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(AES);
            // 初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.decodeBase64(ciphertext)), "UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException("AES解密失败", e);
        }
    }
    
    public static String encrypt(String encodeRules, String plaintext) {
        try {
        	SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
        	//1.构造密钥生成器，指定为AES算法，不区分大小写
        	KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        	//2.根据encodeRules规则初始化密钥生成器
        	//生成256为的随机源
        	keyGen.init(256, random);
        	//3.生成原始对此密钥
        	SecretKey originalKey = keyGen.generateKey();
        	//4.获得原始对称密钥的字节数组
        	byte [] raw = originalKey.getEncoded();
            //5. 根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, AES);
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(AES);
            // 初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.encodeBase64String(cipher.doFinal(plaintext.getBytes("UTF-8")));
        } catch (Throwable e) {
            throw new RuntimeException("AES加密失败", e);
        }
    }

    public static String decrypt(String encodeRules, String ciphertext) {
        try {
        	SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
        	//1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个256位的随机源,根据传入的字节数组
            keygen.init(256, random);
              //3.产生原始对称密钥
            SecretKey original_key=keygen.generateKey();
              //4.获得原始对称密钥的字节数组
            byte [] raw=original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key=new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(AES);
            // 初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.decodeBase64(ciphertext)), "UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException("AES解密失败", e);
        }
    }
    
    public static void main(String[] args) {
    	
    	
    	String id = "wkoiaOo+FEXKEfzHbOR/WA\u003d\u003d";    	
    	id = AESUtil.decrypt(AESUtil.AES_KEY, id);
    	System.out.println(id);
    	System.out.println(AESUtil.encrypt(AESUtil.AES_KEY, id));

    	
	}
}
