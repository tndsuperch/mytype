package cn.mytype.mvc.model.user;

import cn.mytype.validator.constraints.MTNotEmpty;

public class User {

    @MTNotEmpty(message="{msg001}")
    private String id;
    private String name;
    private String age;
    private String birth;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
}
