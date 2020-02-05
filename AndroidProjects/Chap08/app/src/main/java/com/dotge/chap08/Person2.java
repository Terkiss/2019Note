package com.dotge.chap08;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Person2 implements Parcelable {
    private static final long serialVersionUID = 1000001L;
    Parcel a;
    String name;
    int age;
    String phone;
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
