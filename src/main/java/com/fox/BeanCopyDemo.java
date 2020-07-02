package com.fox;

import com.fox.bean.SourceBean;
import com.fox.bean.TargetBean;
import com.fox.util.BeanMapper;
import org.apache.commons.beanutils.BeanMap;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2018/9/11
 * @Version: [v1.0]
 */
public class BeanCopyDemo {

    public static void main(String[] args) {
        SourceBean sourceBean = new SourceBean("fox", 20, "新华金融大厦", "13567899876");
        TargetBean targetBean = new TargetBean();
        BeanMapper.copy(sourceBean, targetBean);

        System.out.println(targetBean);
    }


}
