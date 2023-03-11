package Cipher;

public class CipherMethod {
    private IEncryptable callbackFtn;

    public String encryptText(String plainText, String cipher) {
        Encryption encryption = new Encryption();
        callbackFtn = encryption.getMonoCipherMethod();
        return callbackFtn.encrypt(plainText, cipher);
    }

    public String decryptText(String cipherText, String cipher) {
        Encryption encryption = new Encryption();
        callbackFtn = encryption.getMonoCipherMethod();
        return callbackFtn.decrypt(cipherText, cipher);
    }

//    public static void main(String[] args) {
//        CipherMethod cipherMethod = new CipherMethod();
//        System.out.println(cipherMethod.encryptText("weATHer", "fEAtHeR"));
//        System.out.println(cipherMethod.decryptText("GHFKYHM", "FEATHER"));
//    }
}
