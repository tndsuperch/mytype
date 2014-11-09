package cn.mytype.mvc.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.mytype.dao.user.UserDao;
import cn.mytype.domain.User;
import cn.mytype.mvc.service.AbstractService;

@Service
@Transactional
public class UserDeleteService extends AbstractService<User, Object> {

    @Autowired
    private UserDao userDao;

    @Override
    protected Object doExecute(User user) {
        return userDao.deleteUser(user);
    }

}
