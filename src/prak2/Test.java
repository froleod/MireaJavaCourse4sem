package prak2;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        LinkedList<Human> humans = new LinkedList<>();
        humans.add(new Human(20, "John", "John", new Date(2024), 56));
        humans.add(new Human(42, "Mike", "Mike", new Date(2023), 90));
        humans.add(new Human(31, "Elen", "Elen", new Date(2022), 52));
        humans.add(new Human(26, "Peter", "Peter", new Date(2021), 77));
        System.out.println("Sorted for age > 20:");
        humans.stream().filter(h -> h.getAge() > 20).toList().forEach(System.out::println);

        System.out.println("-----------------------------");

        System.out.println("Sorted for last char of name:");
        humans.stream().sorted(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getFirstName().charAt(o1.getFirstName().length() - 1) - o2.getFirstName().charAt(o2.getFirstName().length() - 1);
            }
        }).toList().forEach(System.out::println);

        System.out.println("-----------------");
        System.out.println("Rising age at 3:");
        humans.stream().peek(h -> h.setAge(h.getAge() + 3)).toList().forEach(System.out::println);

        System.out.println("-----------------");
        double avgAge = humans.stream().mapToInt(Human::getAge).average().orElse(0);
        System.out.println("Avg age: " + avgAge);
    }
}
