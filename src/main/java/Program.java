import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Map<String, String> file = null;
        String pathGlob = "";
        boolean b = true;
        while(b){
            System.out.println("Выберите один из вариантов:");
            System.out.println("1 - Открыть файл для чтения и записи");
            System.out.println("2 - Проверить пользователя");
            System.out.println("3 - Добавить пользователя");
            System.out.println("4 - Удалить пользователя");
            System.out.println("5 - Выйти из программы");
            Scanner in = new Scanner(System.in);
            Scanner infile = new Scanner(System.in);
            Scanner inuser = new Scanner(System.in);
            Scanner innewuser = new Scanner(System.in);
            Scanner innewuser2 = new Scanner(System.in);
            int value = in.nextInt();
            Person person = new Person();
            switch (value){
                case 1:
                    String path = "";
                    while (path.equals("")){
                        System.out.println("Введите путь к файлу:");
                        path = infile.nextLine();
                        pathGlob = path;
                        file = open_file(path);
                        if (file == null){
                            path = "";
                        }
                    }
                    break;
                case 2:
                    System.out.println("Проверка пользователя...");
                    System.out.println("Введите имя пользователя:");
                    String user = inuser.nextLine();
                    System.out.println("Введите пароль пользователя:");
                    String password = inuser.nextLine();
                    person.input(file, user, password);
                    break;
                case 3:
                    System.out.println("Добавление пользователя...");
                    System.out.println("Введите имя пользователя:");
                    String new_user = innewuser.nextLine();
                    System.out.println("Введите пароль пользователя:");
                    String new_password = innewuser.nextLine();
                    person.register(file, new_user, new_password,pathGlob);
                    file = open_file(pathGlob);
                    break;
                case 4:
                    System.out.println("Удаление пользователя...");
                    System.out.println("Введите имя пользователя:");
                    String new_user2 = innewuser2.nextLine();
                    System.out.println("Введите пароль пользователя:");
                    String new_password2 = innewuser2.nextLine();
                    person.register(file, new_user2, new_password2,pathGlob);
                    file = open_file(pathGlob);
                    break;
                case 5:
                    b = false;
                    break;
                default:
                    System.out.println("Такой команды нет!");
                    break;
            }
        }
    }
    public static Map<String,String> open_file(String path) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (IOException io){
            System.out.println("Файл не найден, повторите попытку.");
            return null;
        }
        String line;
        Map<String,String> lines = new HashMap<String, String>();
        while ((line = reader.readLine()) != null) {
            String[] subStr;
            subStr = line.split(" ");
            lines.put(subStr[0],subStr[1]);
        }
        System.out.println("Файл открыт");
        return lines;
    }
}
