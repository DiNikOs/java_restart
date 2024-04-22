
public class Task1 {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alex", "1234");
        phoneBook.add("Alexy", "11234");
        phoneBook.add("Alexy", "21234");
        phoneBook.add("Zenia", "1111");
        phoneBook.add("Wert", "2222");
        phoneBook.add("Wert", "3333");
        phoneBook.add("Wert", "4444");
        phoneBook.add("Werty", "111111");
        phoneBook.add("Werty", "222222");
        phoneBook.add("Werty", "333333");
        phoneBook.add("Werty", "444444");
        Commands.runPhoneBook(phoneBook);
    }
}
