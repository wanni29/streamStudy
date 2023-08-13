import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    
}


public class StreamStudy5 {
    public static void main(String[] args) {
        
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 22));
        people.add(new Person("David", 28));
        people.add(new Person("Eve", 21));

        Map<Integer, List<String>> ageToNameMap = people.stream()
        .filter(person -> person.getAge() >= 25)
        .sorted(Comparator.comparingInt(Person::getAge).reversed())
        .collect(Collectors.groupingBy(
            Person::getAge,
            Collectors.mapping(Person::getName, Collectors.toList())
        ));

        // .collect(Collectors,groupingBy(키값, 밸류값));
        // 여기서는 Person::getAge -> 키값으로 그룹핑을 할꺼고
        // Person::getName 이라는것을 추출해 낸다.

        ageToNameMap.entrySet().stream()
        .forEach(entry -> {
            System.out.println("Age : " + entry.getKey());
            System.out.println("Names : " + entry.getValue());
        });

        double averageAge = people.stream()
        .mapToInt(Person::getAge) // 나이값만 추출하겠다.
        .average() // :: 무슨 메서드 쓸지 지정하는거임
        .orElse(0.0); // 평균값이 없는 경우에는 디폴트 값 0을 반환

        System.out.println(averageAge);
    }
    
}
