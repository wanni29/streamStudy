import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StreamStudy8 {
    public static void main(String[] args) {

        // 데이터 생성
        Stream<String> wordStream = Stream.of("apple", "banana", "apple", "orange", "banana", "grape", "grape");


        // 각 단어의 개수를 세어서 HashMap에 저장
        Map<String, Integer> wordCountMap = wordStream.collect(
            HashMap::new, // 객체를 만들고 new 한거임!
            (map, word) -> map.put(word, map.getOrDefault(word, 0) + 1), 
            // 객체를 만들었는데 HashMap 타입이고 
            // 객체의 이름이 map 인거임
            // map 이라는 변수가 hashmap의 키가 되는거고
            // word 라는 애가 value 값이 되는거임
            // 그리고 그거를 착착 넣는거지 put 으로 
            HashMap::putAll
        );

        // 개수가 2보다 큰 단어만 StringBuilder를 이용해 형식에 맞게 문자열 생성
        StringBuilder result = new StringBuilder();
        wordCountMap.entrySet().stream()
        .filter(entry -> entry.getValue() >= 2)
        .sorted(Map.Entry.comparingByKey())
        .forEach(entry -> {
            result.append("Word: ").append(entry.getKey())
            .append(", Count: ").append(entry.getValue()).append("\n");
        });

        System.out.println("Words with count greater than 2:\n" + result.toString());

    }

}
