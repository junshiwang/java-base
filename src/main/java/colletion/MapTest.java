package colletion;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> hashMap = new HashMap<>();
        //添加元素到 Map 中
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key4", "value4");
        hashMap.put("key5", "value5");

        //删除 Map 中的元素,通过 key 的值
        hashMap.remove("key1");

        //通过 get(key) 得到 Map 中的value
        Object str1 = hashMap.get("key1");

        //可以通过 添加 方法来修改 Map 中的元素
        hashMap.put("key2", "修改 key2 的 Value");

        //通过 map.values() 方法得到 Map 中的 value 集合
        Collection<Object> value = hashMap.values();
        for(Object obj : value){
            //System.out.println(obj);
        }

        //通过 map.keySet() 得到 Map 的key 的集合，然后 通过 get(key) 得到 Value
        Set<String> set = hashMap.keySet();
        for(String str : set){
            Object obj = hashMap.get(str);
            System.out.println(str+"="+obj);
        }

        //通过 Map.entrySet() 得到 Map 的 Entry集合，然后遍历
        Set<Map.Entry<String, Object>> entrys = hashMap.entrySet();
        for(Map.Entry<String, Object> entry: entrys){
            String key = entry.getKey();
            Object value2 = entry.getValue();
            System.out.println(key+"="+value2);
        }

        System.out.println(hashMap);
    }
}
