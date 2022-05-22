package com.live.clg_project.Model;

public class UserData1 {
    String userid;
    String name;
    String phone;
    String age;
    String house_name;
    String house_number;
    String ward;
    String address;
    String designation;

    public UserData1(String userid, String name, String phone, String age, String house_name, String house_number, String ward, String address, String designation) {
        this.userid = userid;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.house_name = house_name;
        this.house_number = house_number;
        this.ward = ward;
        this.address = address;
        this.designation = designation;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
