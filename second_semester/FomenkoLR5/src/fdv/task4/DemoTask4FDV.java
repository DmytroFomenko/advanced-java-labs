package fdv.task4;


import java.io.File;
import java.io.IOException;

import static fdv.task4.PasswordEncryption.decrypt;
import static fdv.task4.PasswordEncryption.encrypt;

public class DemoTask4FDV {

    public static void main(String[] args) throws IOException {
        String strPathToProjectDir = new File(".").getAbsolutePath();
        String strPathToFile = strPathToProjectDir + "login.info";
        PasswordEncryption p = new PasswordEncryption();


        p.mkFile(strPathToFile);

        String login = p.scanLogin();
        String password = p.scanPassword();
        System.out.println();

        String loginData = login + "*" + password;

        System.out.println("Encrypting login data...");
        String encryptedString = encrypt(loginData);
        System.out.println();

        if (p.writeStringToFile(encryptedString, strPathToFile)) {
            System.out.println("Encrypted login data is written to a file!!!");
        } else {
            System.out.println("Error in writing to file...");
        }
        System.out.println();

        String encryptedDataFromFile = p.readStringFromFile(strPathToFile);
        System.out.println("Encrypted login data from file: " + encryptedDataFromFile);
        System.out.println();

        System.out.println("Decrypting login data...");
        String decryptedData = decrypt(encryptedDataFromFile);
        System.out.println();

        assert decryptedData != null;
        System.out.println("Decrypted login: " + p.getLoginFromData(decryptedData));
        System.out.println("Decrypted password: " + p.getPasswordFromData(decryptedData));

        System.out.println();
    }
}
