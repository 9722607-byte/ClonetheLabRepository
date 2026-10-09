package ua.opnu;

public class Main {
    public static void main(String[] args) {
        // Завдання 2: поліморфний масив
        Person[] people = new Person[3];
        people[0] = new Person("Іваненко", "Іван", 40);
        people[1] = new Student("Вигнанюк", "Андрій", 18, "АІ-253", "KB123456");
        people[2] = new Lecturer("Блажко", "Олександр", 45, "Системного програмного забезпечення", 25000);

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}