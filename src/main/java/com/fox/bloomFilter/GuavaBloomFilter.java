package com.fox.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2020/2/20
 * @Version: [v1.0]
 */
public class GuavaBloomFilter {
    public static void main(String[] args) {

        long star = System.currentTimeMillis();


        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }



//        Assert.assertTrue(filter.mightContain(1));
//        Assert.assertTrue(filter.mightContain(2));
//        Assert.assertTrue(filter.mightContain(3));
//        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }


}
