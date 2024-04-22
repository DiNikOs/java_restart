import java.util.*;

public class PhoneBook {

    private static HashMap<String, ArrayList<String>> phoneBook = new LinkedHashMap<>();

    public void add(String name, String phoneNum) {
        ArrayList<String> phones = findOrNew(name);
        phones.add(phoneNum);
        phoneBook.put(name, phones);
        sortPhoneBook();
    }

    public ArrayList<String> findOrNew(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public ArrayList<String> getPhones(String name) {
        return phoneBook.get(name);
    }

    public HashMap<String, ArrayList<String>> getPhoneBook() {
        return phoneBook;
    }

    public void sortPhoneBook() {
        List<Map.Entry<String, ArrayList<String>>> list = new LinkedList<>(phoneBook.entrySet());
        // Компаратор для сортировки по убыванию числа телефонов
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList<String>>>() {
            public int compare(Map.Entry<String, ArrayList<String>> o1, Map.Entry<String, ArrayList<String>> o2) {
                if (o1.getValue().size() == o2.getValue().size()) {
                    return 0;
                } else if (o1.getValue().size() > o2.getValue().size()) {
                    return -1;
                }
                return 1;
            }
        });

        HashMap<String, ArrayList<String>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        phoneBook = sortedMap;
    }

    public ArrayList<String> removePhoneBook(String name) {
        ArrayList<String> values = phoneBook.remove(name);
        if (values != null) {
            sortPhoneBook();
        }
        return values;
    }
}
