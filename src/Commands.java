import java.util.*;

public class Commands {

    public static void runPhoneBook(PhoneBook phoneBook) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Выберете действие: 1 - весь список, 2 - добавление, 3 - поиск, 4 - удаление, q - выход");
            String op = scanner.next();
            if (op == null) {
                System.out.println("Не пустое значение! Повторите выбор.");
                continue;
            }
            switch (op) {
                case "1":
                    getContacts(phoneBook);
                    break;
                case "2":
                    saveContact(scanner, phoneBook);
                    break;
                case "3":
                    getContact(scanner, phoneBook);
                    break;
                case "4":
                    removeContact(scanner, phoneBook);
                    break;
                case "q":
                    flag = false;
                    System.exit(0);
                default:
                    System.out.println("Команда не найдена! Повторите выбор." + phoneBook.getPhoneBook());
                    continue;
            }
        }
    }

    public static void getContacts(PhoneBook phoneBook) {
        System.out.println("Список контактов: " + phoneBook.getPhoneBook());
    }

    public static void getContact(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Укажете имя контакта");
        String searchName = scanner.next();
        List<String> phones = phoneBook.getPhones(searchName);
        if (phones != null) {
            System.out.println(searchName + ": " + phones);
        } else {
            System.out.println("Контакт '" + searchName + "' не найден!");
        }
    }

    public static void saveContact(Scanner scanner, PhoneBook phoneBook) {
        System.out.print("Укажете имя контакта: ");
        String contName = scanner.next();
        System.out.print("Укажете номер телефона: ");
        String numPhone = scanner.next();
        phoneBook.add(contName, numPhone);
        System.out.printf("Контакт '%s' сохранён\n", contName);
    }

    public static void removeContact(Scanner scanner, PhoneBook phoneBook) {
        System.out.println("Укажете имя контакта");
        String delName = scanner.next();
        System.out.println("Удаление контакта '" + delName + "': " + phoneBook.removePhoneBook(delName));
    }
}
