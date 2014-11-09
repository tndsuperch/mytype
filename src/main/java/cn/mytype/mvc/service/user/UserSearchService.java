package cn.mytype.mvc.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.mytype.MyTypeException;
import cn.mytype.dao.user.UserDao;
import cn.mytype.domain.User;
import cn.mytype.mvc.model.UserSearchCommand;
import cn.mytype.mvc.service.AbstractService;

@Service
@Transactional
public class UserSearchService extends AbstractService<UserSearchCommand, List<User>> {

    @Autowired
    private UserDao userDao;

    @Override
    protected List<User> doExecute(UserSearchCommand searchCommand) {
        List<User> userList = new ArrayList<User>();
        if (searchCommand.getCommand() == UserSearchCommand.SELECT_ALL) {
            userList = userDao.getUserListAll();
        } else if (searchCommand.getCommand() == UserSearchCommand.SELECT_ONE) {
            User user = searchCommand.getUser();
            userList.add(userDao.getUserById(user.getId()));
        } else {
            throw new MyTypeException();
        }
        return userList;
    }

}
