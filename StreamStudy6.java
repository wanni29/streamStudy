import java.util.HashMap;

public class StreamStudy6 {
    
    public static void main(String[] args) {
        HashMap <String, Integer> dataMap = new HashMap<>();
        dataMap.put("apple", 3);
        dataMap.put("banana", 5);
        dataMap.put("orange", 2);


        // StringBuilder를 활용한 결과 문자열 생성
        StringBuilder result = new StringBuilder();
        dataMap.entrySet().stream()
        .filter(entry -> entry.getValue() > 2)
        .map(entry -> "We have " + entry.getValue() + " " + entry.getKey() + "s.")
        .forEach(str -> result.append(str).append(" "));

        //  최종
        System.out.println("Final Result : " + result.toString().trim());

    }
}
