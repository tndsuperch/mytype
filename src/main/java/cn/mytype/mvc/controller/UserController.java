package cn.mytype.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mytype.PathConfig;
import cn.mytype.mvc.model.user.SearchCommand;
import cn.mytype.mvc.model.user.User;
import cn.mytype.mvc.service.user.UserRegisterService;
import cn.mytype.mvc.service.user.UserSearchService;


@Controller
public class UserController extends MyTypeController {

    @Autowired
    private UserSearchService userSearchService;

    @Autowired
    private UserRegisterService userRegisterService;

    @RequestMapping(value=PathConfig.TO_USER_LIST)
    public String listUsers(Model model) {
        SearchCommand searchCommand = new SearchCommand(SearchCommand.SELECT_ALL);
        List<User> users = userSearchService.execute(searchCommand);
        model.addAttribute("users", users);
        return PathConfig.TO_USER_LIST_VIEW;
    }

    @RequestMapping(value=PathConfig.TO_USER_REGISTER_INIT)
    public String registerInit(User user) {
        return PathConfig.TO_USER_REGISTER_VIEW;
    }

    @RequestMapping(value=PathConfig.TO_USER_REGISTER)
    public String register(@Valid User user, BindingResult bindingResult) {

        System.out.println(user.getFile().getOriginalFilename());

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            // 注意：此处不能用forward,否则错误消息带不到画面上
            return PathConfig.TO_USER_REGISTER_VIEW;
        }

        userRegisterService.execute(user);
        return PathConfig.FORWARD_USER_LIST;
    }

}
