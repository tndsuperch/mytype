package cn.mytype.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mytype.Constants;
import cn.mytype.PathConfig;
import cn.mytype.config.MessagesConfig;
import cn.mytype.domain.User;
import cn.mytype.domain.UserSearchCommand;
import cn.mytype.mvc.model.UserForm;
import cn.mytype.mvc.service.user.UserRegisterService;
import cn.mytype.mvc.service.user.UserSearchService;
import cn.mytype.utils.BeanUtil;


@Controller
public class UserController extends MyTypeController {

    @Autowired
    private UserSearchService userSearchService;

    @Autowired
    private UserRegisterService userRegisterService;

    @RequestMapping(value=PathConfig.TO_USER_LIST)
    public String listUsers(@ModelAttribute("userForm") UserForm userForm) {
        UserSearchCommand searchCommand = new UserSearchCommand(UserSearchCommand.SELECT_ALL);
        List<User> users = userSearchService.execute(searchCommand);
        userForm.setUsers(users);
        return PathConfig.TO_USER_LIST_VIEW;
    }

    @RequestMapping(value=PathConfig.TO_USER_REGISTER_INIT)
    public String registerInit(UserForm userForm) {
        return PathConfig.TO_USER_REGISTER_VIEW;
    }

    @RequestMapping(value=PathConfig.TO_USER_REGISTER)
    public String register(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult bindingResult, HttpServletRequest request) {

        String kaptchaText = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (!userForm.getKaptcha().equals(kaptchaText)) {
            bindingResult.rejectValue("kaptcha", MessagesConfig.MsgErrKaptchaDifferent.getKey());
        }

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            // 注意：此处不能用forward,否则错误消息带不到画面上
            return PathConfig.TO_USER_REGISTER_VIEW;
        }

        User user = new User();
        BeanUtil.copyProperties(userForm, user);
        userRegisterService.execute(user);
        return PathConfig.FORWARD_USER_LIST;
    }

}
