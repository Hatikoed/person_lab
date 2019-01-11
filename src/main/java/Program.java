import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException {
        Map<String, String> file = null;
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
            int value = in.nextInt();
            Person person = new Person();
            switch (value){
                case 1:
                    String path = "";
                    while (path.equals("")){
                        System.out.println("Введите путь к файлу:");
                        path = infile.nextLine();
                        file = open_file(path);
                        if (file == null){
                            path = "";
                        }
                    }
                    break;
                case 2:
                    person.input();
                    break;
                case 3:
                    person.register();
                    break;
                case 4:
                    person.delete();
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
