//package com.scotiabank.riskmanagement.testcdoe;
//
//import org.jasypt.util.text.BasicTextEncryptor;
//
//
//public class BasicTextEncryptorTest {
//
//    public static void main(String[] a){
//        testEncrypt();
//    }
//
//    public static void testEncrypt() {
//        String message = "010-1111-1111";
//
//        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
//        basicTextEncryptor.setPassword("1234qwer");
//        String encryptedMessage = basicTextEncryptor.encrypt(message);
//        String decryptedMessage = basicTextEncryptor.decrypt(encryptedMessage);
//        System.out.println("encryptedMessage "+encryptedMessage);
//        System.out.println("decryptedMessage: "+ decryptedMessage);
//
//        basicTextEncryptor = new BasicTextEncryptor();
//        basicTextEncryptor.setPassword("qwer1234");
//        encryptedMessage = basicTextEncryptor.encrypt(message);
//        decryptedMessage = basicTextEncryptor.decrypt(encryptedMessage);
//        System.out.println("encryptedMessage: "+encryptedMessage);
//        System.out.println("decryptedMessage: "+decryptedMessage);
//
//
//    }
//
//}
