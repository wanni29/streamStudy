import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamStudy7 {

    public static void main(String[] args) {
        // 데이터 생성
        List<String> fruitList = new ArrayList<>();

        fruitList.add("apple");
        fruitList.add("banana");
        fruitList.add("apple");
        fruitList.add("orange");
        fruitList.add("banana");

        // 각 과일의 개수를 세어서 hashMap
        Map<String, Integer> fruitCountMap = new HashMap<>();

        for (String fruit : fruitList) {
            fruitCountMap.put(fruit, fruitCountMap.getOrDefault(fruit, 0) + 1);
        }

        // 개수가 2보다 큰 과일 이름만 추출하여 정렬된 리스트 생성
        List<String> result = fruitCountMap.entrySet().stream()
        .filter(entry -> entry.getValue() >= 2)
        .map(Map.Entry::getKey)
        .sorted()
        .collect(Collectors.toList());

        // 최종... 최최종
        System.out.println("Fruits with count greater than 2 : " + result);
    }

}
