import java.io.UnsupportedEncodingException;
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
                System.out.println("Пользователь активен");
                return true;
            } else {
                System.out.println("Пароль введен не верно");
                return true;
            }
        } else {
            System.out.println("Такого пользователя не существует");
            return true;
        }
    }
    public boolean register(){
        return false;
    }
    public boolean delete(){
        return false;
    }
}
