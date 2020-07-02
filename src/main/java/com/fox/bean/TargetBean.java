package com.fox.bean;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2018/9/11
 * @Version: [v1.0]
 */
public class TargetBean {

    private String targetName;

    private Integer targetAge;

    private String targetAddress;

    private String targetPhone;

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public Integer getTargetAge() {
        return targetAge;
    }

    public void setTargetAge(Integer targetAge) {
        this.targetAge = targetAge;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public String getTargetPhone() {
        return targetPhone;
    }

    public void setTargetPhone(String targetPhone) {
        this.targetPhone = targetPhone;
    }

    @Override
    public String toString() {
        return "TargetBean{" +
                "targetName='" + targetName + '\'' +
                ", targetAge=" + targetAge +
                ", targetAddress='" + targetAddress + '\'' +
                ", targetPhone='" + targetPhone + '\'' +
                '}';
    }
}
