package fdv.task4;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Scanner;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.isRegularFile;

public class PasswordEncryption {
    public void mkFile(String strPath) throws IOException {
        File f = new File(strPath);
        Files.deleteIfExists(Path.of(strPath));
        f.createNewFile();
    }


    public static String encrypt(String value) {
        String key = "aesEncryptionKey";
        String initVector = "encryptionIntVec";
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static String decrypt(String encrypted) {
        String key = "aesEncryptionKey";
        String initVector = "encryptionIntVec";
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public boolean writeStringToFile(String string, String strPath) throws IOException {
        Path path = Path.of(strPath);

        if (exists(path) && isRegularFile(path)) {
            FileWriter writer;
            writer = new FileWriter(strPath);

            writer.write(string);
            writer.close();
            return true;
        } else {
            return false;
        }
    }

    public String readStringFromFile(String strPath) throws IOException {
        File file = new File(strPath);
        InputStream is = new FileInputStream(file);
        long length = file.length();

        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }
        is.close();
        return new String(bytes);
    }


    public String scanLogin() {
        Scanner scan = new Scanner(System.in);
        String login;
        do {
            System.out.print("Enter your login (symbol * is forbidden): ");
            login = scan.nextLine();
        } while (!login.matches("[^*]+"));
        return login;
    }

    public String scanPassword() {
        Scanner scan = new Scanner(System.in);
        String password;
        do {
            System.out.print("Enter your password (symbol * is forbidden): ");
            password = scan.nextLine();
        } while (!password.matches("[^*]+"));
        return password;
    }

    public String getLoginFromData(String allData) {
        String[] words = allData.split("(?<=[*])|(?=[*])");
        return words[0];
    }

    public String getPasswordFromData(String allData) {
        String[] words = allData.split("(?<=[*])|(?=[*])");
        return words[2];
    }


}
