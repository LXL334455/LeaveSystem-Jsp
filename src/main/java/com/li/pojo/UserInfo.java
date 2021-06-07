package com.li.pojo;


public class UserInfo {
    private Integer UserID;
    private  String LoginName;
    private String PassWord;
    private Integer UserRole;

    public UserInfo() {
    }

    public UserInfo(Integer userID, String loginName, String passWord, Integer userRole) {
        UserID = userID;
        LoginName = loginName;
        PassWord = passWord;
        UserRole = userRole;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public Integer getUserRole() {
        return UserRole;
    }

    public void setUserRole(Integer userRole) {
        UserRole = userRole;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "UserID=" + UserID +
                ", LoginName='" + LoginName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", UserRole=" + UserRole +
                '}';
    }
}
