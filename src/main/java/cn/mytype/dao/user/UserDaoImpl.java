package cn.mytype.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mytype.mvc.model.user.User;

@Component
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<User> getUserListAll() {
        return getSqlSession().selectList("user.getUserListAll");
    }

    public User getUserById(String id) {
        return getSqlSession().selectOne("user.getUserById", id);
    }

    public int insertUser(User user) {
        return getSqlSession().insert("user.insertUser", user);
    }

    public int updateUser(User user) {
        return getSqlSession().update("user.updateUser", user);
    }

    public int deleteUser(User user) {
        return getSqlSession().delete("user.deleteUser", user);
    }

}
