package model;

/*
    AUTHOR: linux
    TIME: 2019/12/20
    GOOD LUCK AND NO BUG.
*/

import java.io.Serializable;

public class User implements Serializable {
    private String uname;
    private String upwd;
    private String msg;
    private String friend;
    private String msgType;

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public User() {

    }

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }
}
