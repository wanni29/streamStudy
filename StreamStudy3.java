import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

public class StreamStudy3 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 28),
                new User("Bob", 22),
                new User("Charlie", 35),
                new User("David", 30),
                new User("Eve", 25),
                new User("Frank", 40));

        Map<Integer, User> oldestUsersByAgeGroup = users.stream()
                .filter(user -> user.getAge() >= 30)
                .sorted(Comparator.comparing(User::getAge).reversed())
                .collect(Collectors.groupingBy(
                        user -> (user.getAge() / 10) * 10,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                userList -> userList.get(0))));

        oldestUsersByAgeGroup.forEach(
                (ageGroup, user) -> System.out.println("Oldest user in age group " + ageGroup + ":" + user.getName()));

    }

}
