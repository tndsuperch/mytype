package cn.mytype.dao.user;

import java.util.List;

import cn.mytype.domain.User;

public interface UserDao {

    public List<User> getUserListAll();

    public User getUserById(String id);

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(User user);

}