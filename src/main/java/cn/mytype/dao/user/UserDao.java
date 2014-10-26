package cn.mytype.dao.user;

import java.util.List;

import cn.mytype.mvc.model.user.User;

public interface UserDao {

    public List<User> getUserListAll();

    public User getUserById(String id);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(User user);

}