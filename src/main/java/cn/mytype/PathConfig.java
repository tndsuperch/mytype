package cn.mytype;


/**
 * 常量定义规则：
 * RequestMapping的入口PATH:    TO_XXXX
 * HTML VIEW的PATH:    TO_XXXX_VIEW
 * Forward的时候:    FORWARD_XXXX
 * Redirect的时候:    REDIRECT_XXXX
 * @author tndsuperch
 *
 */
public final class PathConfig {

    private PathConfig() {
        super();
    }

    public static final String TO_ERROR_VIEW            = "error";
    public static final String TO_USER_LIST             = "/user/list";
    public static final String TO_USER_LIST_VIEW        = "user/userList";
    public static final String TO_USER_REGISTER_INIT    = "/user/registerInit";
    public static final String TO_USER_REGISTER_VIEW    = "user/userRegister";
    public static final String TO_USER_REGISTER         = "/user/register";
    public static final String FORWARD_USER_LIST        = "forward:/user/list";


}
