package cn.mytype.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String listUsers(Model model) {
        SearchCommand searchCommand = new SearchCommand(SearchCommand.SELECT_ALL);
        List<User> users = userSearchService.execute(searchCommand);
        model.addAttribute("users", users);
        return "/user/userList";
    }

    @RequestMapping(value="/registerInit")
    public String registerInit(User user) {
        return "/user/userRegister";
    }

    @RequestMapping(value="/register")
    public String register(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "/user/userRegister";
        }

        userRegisterService.execute(user);
        return "forward:/user/list";
    }
}
