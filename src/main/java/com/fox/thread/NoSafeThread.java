package com.fox.thread;

import org.apache.hadoop.util.hash.Hash;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/7/25
 * @Version: [v1.0]
 */
public class NoSafeThread {

    private StringBuilder sb = new StringBuilder();

    private ConcurrentHashMap<Long, Long> hashMap = new ConcurrentHashMap<>();

    public void add(String text) {
        sb.append(text);
    }

}
