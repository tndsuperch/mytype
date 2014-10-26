package cn.mytype.mvc.model.user;

public class SearchCommand {
    public static int SELECT_ONE = 0;
    public static int SELECT_ALL = 1;

    private int command = -1;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SearchCommand() {
        super();
    }

    public SearchCommand(int command) {
        super();
        this.command = command;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

}
