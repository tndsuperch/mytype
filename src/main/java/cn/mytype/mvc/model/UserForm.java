package cn.mytype.mvc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.mytype.domain.User;
import cn.mytype.validator.constraints.MTLength;
import cn.mytype.validator.constraints.MTNotEmpty;
import cn.mytype.validator.constraints.MTNumber;
import cn.mytype.validator.constraints.MTRange;

public class UserForm implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2526064439199600943L;

    @MTNotEmpty(name="用户ID")
    @MTLength(name="用户ID", min=1, max=10)
    private String id;

    @MTNotEmpty(name="用户姓名")
    private String name;

    @MTRange(name="年龄", min=18, max=150)
    private String age;

    @MTNotEmpty(name="生日")
    private String birth;

    @MTNotEmpty(name="验证码")
    @MTNumber(name="验证码")
    private String kaptcha = null;

    private MultipartFile file;

    private List<User> users = new ArrayList<User>();

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

    public String getKaptcha() {
        return kaptcha;
    }

    public void setKaptcha(String kaptcha) {
        this.kaptcha = kaptcha;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public MultipartFile getFile() {
        return file;
    }
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
