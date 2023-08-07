import java.util.Arrays;
import java.util.List;

public class StreamStudy2 {
    public static void main(String[] args) {

        // 예제 1
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "kiwi");

        fruits.stream()
                .filter(fruit -> fruit.length() > 5) // 글자가 5보다 큰과일만 필터링
                .map(String::toUpperCase) // 모든 과일 이름을 대문자로
                .forEach(System.out::println);

        // 예제 2
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfEvenNumberes = numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum of even numbers : " + sumOfEvenNumberes);

        // 참고 하기 "::"
        // 람다 표현식 사용
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(number -> System.out.println(nums1));

        // 메소드 레퍼런스 사용
        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);
    }
}
