package cn.mytype.mvc.model.user;

import cn.mytype.validator.constraints.MTLength;
import cn.mytype.validator.constraints.MTNotEmpty;
import cn.mytype.validator.constraints.MTRange;


public class User {

    @MTNotEmpty(name="用户ID")
    @MTLength(name="用户ID", min=1, max=10)
    private String id;
    @MTNotEmpty(name="用户姓名")
    private String name;
    @MTRange(name="年龄", min=18, max=150)
    private String age;
    @MTNotEmpty(name="生日")
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
