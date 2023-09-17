import java.util.HashMap;
import java.util.Iterator;

public class HashMapPrac {
    public static void main(String[] args) {
        // key: Intger, value: Integer인 HashMap을 생성
        HashMap<Integer, Integer> map = new HashMap<>();
        // put(k, v) : 해쉬맵에 (k, v)를 저장
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        
        // get(k) : 키값이 k인 값을 반환, 없을 시 오류
        System.out.println("key가 1인값 받기: " + map.get(1));
        
        // remove(k) : 키값이 k인 값을 삭제
        map.remove(1);
        // containsKey(k) : 키값이 k인 값이 있는지 여부를 판단
        if(map.containsKey(1)) {
            System.out.println(map.get(1));
        } else {
            System.out.println("값이 없습니다.");
        }
        // getOrDefault(k, d) : 키값이 k인 값이 있으면 해당 값을 반환, 없을 시 디폴트값 반환
        System.out.println(map.getOrDefault(1, 10000));
        System.out.println(map.getOrDefault(2, 10000));

        // 값을 몇개 더 추가하고, HashMap을 순회
        map.put(4, 4);
        map.put(5, 5);
        map.put(100, 100);
        
        Iterator keySetIterator = map.keySet().iterator();
        while(keySetIterator.hasNext()) {
            // .hashCode()로 순회하며 찾아지긴 하지만 더 알아봐야함
            Integer key = keySetIterator.next().hashCode();
            System.out.println("Key: " + key + " / Value: " + map.get(key));
        }
    }
}
