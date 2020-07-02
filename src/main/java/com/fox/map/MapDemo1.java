package com.fox.map;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/5/23
 * @Version: [v1.0]
 */
public class MapDemo1 {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");

        map.replaceAll((k, v) -> {
            if (k == 1) {
                v = "c";
            }
            if (k == 2) {
                v = "d";
            }
            return v;
        });

        System.out.println(JSON.toJSONString(map));


//        Map<Integer, String> map = new HashMap<>();
//        String a = map.putIfAbsent(1, "a");
//        map.putIfAbsent(2, "b");
//        map.putIfAbsent(3, "c");
//
//        System.out.println(map.merge(1, "merge", (oldValue, newValue) -> oldValue + newValue));
//        System.out.println(map.merge(4, "merge", (oldValue, newValue) -> oldValue + newValue));
//        System.out.println(map.merge(1, "merge", (oldValue, newValue) -> null));
//
//        map.computeIfPresent(1, (k, v) -> "fox");
//        System.out.println(map.get(1));
//        map.computeIfPresent(4, (k, v) -> "fox");
//        System.out.println(map.get(4));
//        map.computeIfPresent(1, (k, v) -> null);
//        System.out.println(map.get(1));
//
//        map.computeIfAbsent(1, k -> k + "fox");
//        System.out.println(map.get(1));
//        map.computeIfAbsent(4, k -> "fox" + k);
//        System.out.println(map.get(4));
//
//        map.replace(1, "m");
//        System.out.println(map.get(1));
//        String n = map.replace(4, "n");
//        System.out.println(n);
//
//
//        map.replace(2, "c", "z");
//        System.out.println(map.get(2));
//        map.replace(2, "b", "z");
//        System.out.println(map.get(2));
//        boolean replace = map.replace(4, "b", "z");
//        System.out.println(replace);
//
//        map.remove(1, "b");
//        System.out.println(map.get(1));
//        map.remove(2, "b");
//        System.out.println(map.get(2));
//
//        map.replaceAll((k, v) -> "1");
//
//        map.forEach((k, v) -> System.out.println(k + ":" + v));
//
//        String d = map.getOrDefault(4, "d");
//        System.out.println(d);
//
//        System.out.println(map.get(1));
//        System.out.println(map.get(2));
//        System.out.println(JSON.toJSONString(map));

    }
}
