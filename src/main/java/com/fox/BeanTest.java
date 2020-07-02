package com.fox;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2020/1/8
 * @Version: [v1.0]
 */

public class BeanTest {

    public static void main(String[] args) throws InterruptedException {

        new HashMap<>();
        new CountDownLatch(1);


        BigDecimal a = new BigDecimal(98);
        BigDecimal b = new BigDecimal(101);
        BigDecimal divide = a.divide(b, 4, BigDecimal.ROUND_FLOOR);
        System.out.println(divide);
        BigDecimal c = divide.multiply(new BigDecimal(100));
        System.out.println(c.stripTrailingZeros().toPlainString() + "%");


//        String a = new String("aaa");
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
//        PhantomReference reference = new PhantomReference(a, queue);
//
//
//        ReentrantLock reentrantLock = new ReentrantLock();
//
//        System.gc();
//
//        Thread.sleep(6*1000);
//
//        Reference<?> poll = queue.poll();
//
//        new ThreadLocal<>();

//        poll.


//       Integer a = 2;
//
//       Integer b = 2;
//
//        int i = a & b;
//        System.out.println(i);


//        ClassPathResource resource = new ClassPathResource("bean.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(resource);
    }

    @Test
    public void test() {
        long star = System.currentTimeMillis();

        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }

        Assert.assertTrue(filter.mightContain(1));
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(100000000));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));
        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }
}
