package cn.mytype.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mytype.mvc.model.user.SearchCommand;
import cn.mytype.mvc.model.user.User;
import cn.mytype.mvc.service.user.UserRegisterService;
import cn.mytype.mvc.service.user.UserSearchService;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserSearchService userSearchService;

    @Autowired
    private UserRegisterService userRegisterService;

    @RequestMapping(value="/list")
    public ModelAndView listUsers() {
        SearchCommand searchCommand = new SearchCommand(SearchCommand.SELECT_ALL);
        List<User> users = userSearchService.execute(searchCommand);
        return new ModelAndView("/user/userList", "users", users);
    }

    @RequestMapping(value="/registerInit")
    public String registerInit() {
        return "/user/userRegister";
    }

    @RequestMapping(value="/register")
    public ModelAndView register(User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("forward:/user/registerInit", "user", user);
        }
        userRegisterService.execute(user);
        return new ModelAndView("forward:/user/list");
    }
}
