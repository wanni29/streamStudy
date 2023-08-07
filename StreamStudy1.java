import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy1 {

    public static void main(String[] args) {

        // [중간연산]
        // filter 메소드는 스트림에서 주어진 조건을 만족하는 요소들만을 걸러내는데 사용
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList()); // evenNumbers에는 [2, 4]가 들어있습니다.

        // map 메소드는 스트림의 각 요소를 주어진 함수를 적용하여 새로운 값으로 변환
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names.stream()
                .map(name -> name.length())
                .collect(Collectors.toList()); // nameLengths에는 [5, 3, 7]이 들어있습니다.

        // sorted 메소드는 스트림의 요소들을 기본 정렬 순서 또는 주어진 비교자(Comparator)를 이용하여 정렬
        List<Integer> numbers2 = Arrays.asList(5, 3, 1, 4, 2);
        List<Integer> sortedNumbers = numbers2.stream()
                .sorted()
                .collect(Collectors.toList()); // sortedNumbers에는 [1, 2, 3, 4, 5]가 들어있습니다.

        // [최종 연산]
        // forEach 메소드는 스트림의 각 요소에 대해 주어진 작업을 수행합니다. 스트림의 요소들을 반복하면서 각 요소에 대해 지정된 작업을 실행
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        numbers3.stream().forEach(num -> System.out.println(num));
        // 스트림의 각 요소를 출력합니다.
        // 출력 결과: 1 2 3 4 5

        // ollect 메소드는 스트림의 요소들을 수집하여
        // 새로운 컬렉션을 생성하거나, 요소들을 그룹화하거나,
        // 통계 정보를 계산하는 등의 작업을 수행합니다.
        // collect는 Collectors 클래스의 메소드와 함께 사용
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = numbers4.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
        // numbers 스트림의 각 요소를 제곱하여 새로운 리스트로 수집합니다.
        // squaredNumbers에는 [1, 4, 9, 16, 25]가 들어있습니다.

        // reduce 메소드는 스트림의 모든 요소를 하나로 줄이는 작업을 수행합니다.
        // 주로 요소들을 누적하거나 결합하는데 사용
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers5.stream()
                .reduce(0, (a, b) -> a + b);
        // numbers 스트림의 모든 요소를 더하여 합을 구합니다.
        // sum에는 15가 들어있습니다.

    }

}
