package com.mou.domain;

//用来展示resultMap        当数据库列名和返回对象的属性名不一致时的result方法
public class MyStudent {
    private Integer stuid;
    private String stuname;
    private String stuemail;
    private Integer stuage;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuemail() {
        return stuemail;
    }

    public void setStuemail(String stuemail) {
        this.stuemail = stuemail;
    }

    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stuemail='" + stuemail + '\'' +
                ", stuage=" + stuage +
                '}';
    }
}
