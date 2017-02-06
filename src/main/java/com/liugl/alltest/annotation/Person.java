package com.liugl.alltest.annotation;

/**
 * Created by liugl on 2017/2/4.
 */

public class Person {
    @Name("萝卜丝")
    private String name;
    @Gender(gender = Gender.GenderType.Male)
    private String gender;
    @Profile(id = 1001, height = 180,nativePlace = "cn")
    private String profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
