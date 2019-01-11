import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        boolean b = true;
        while(b){
            System.out.println("Выберите один из вариантов:");
            System.out.println("1 - Открыть файл для чтения и записи");
            System.out.println("2 - Проверить пользователя");
            System.out.println("3 - Добавить пользователя");
            System.out.println("4 - Удалить пользователя");
            System.out.println("5 - Выйти из программы");
            Scanner in = new Scanner(System.in);
            int value = in.nextInt();
            Person person = new Person();
            switch (value){
                case 1:
                    if (open_file()){
                        System.out.println("Файл открыт для чтения и записи:");
                    } else {
                        System.out.println("Открытие файла отменено");
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
    public static boolean open_file(){
        return false;
    }
}
