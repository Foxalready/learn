package com.fox;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/5/13
 * @Version: [v1.0]
 */
public class Student implements Serializable {

    private String name;

    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
