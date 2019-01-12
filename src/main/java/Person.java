import java.io.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Scanner;

public class Person {
    public boolean input(Map<String, String> file, String user, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte[] dataBytes = md.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataBytes.length; i++) {
            sb.append(Integer.toString((dataBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String result = sb.toString();
        String value = file.get(user);
        if (value != null) {
            if(value.equals(result)){
                System.out.println("Пользователь активен!");
                return true;
            } else {
                System.out.println("Пароль введен не верно!");
                return true;
            }
        } else {
            System.out.println("Такого пользователя не существует!");
            return true;
        }
    }
    public boolean register(Map<String, String> file, String user, String password, String path) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte[] dataBytes = md.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataBytes.length; i++) {
            sb.append(Integer.toString((dataBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String result = sb.toString();
        String value = file.get(user);
        if (value != null) {
            System.out.println("Такой пользователь существует!");
            return true;
        } else {
            String new_user = "\r\n" + user + " " + result;
            FileOutputStream fos = new FileOutputStream(path,true);
            byte[] buffer = new_user.getBytes();
            fos.write(buffer, 0, buffer.length);
            System.out.println("Пользователь добавлен!");
            return true;
        }
    }
    public boolean delete(Map<String, String> file, String user, String password,String path) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte[] dataBytes = md.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataBytes.length; i++) {
            sb.append(Integer.toString((dataBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String result = sb.toString();
        String value = file.get(user);
        if (value != null) {
            if(value.equals(result)){
                file.remove(user);
                FileOutputStream fos1 = new FileOutputStream(path);
                String s = "";
                byte[] buffer1 = s.getBytes();
                fos1.write(buffer1, 0, buffer1.length);

                FileOutputStream fos = new FileOutputStream(path,true);
                for (Map.Entry<String, String> entry : file.entrySet()) {
                    String new_line = entry.getKey() + " " + entry.getValue() + "\r\n";
                    byte[] buffer = new_line.getBytes();
                    fos.write(buffer, 0, buffer.length);
                }

                System.out.println("Пользователь удален!");
                return true;
            } else {
                System.out.println("Пароль введен не верно!");
                return true;
            }
        } else {
            System.out.println("Такого пользователя не существует!");
            return true;
        }
    }
}
