package com.li.dao;

import com.li.pojo.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserInfoDao {

    //获取登录用户
    public UserInfo getLoginUser(Connection conn, String LoginName) throws SQLException;


}
