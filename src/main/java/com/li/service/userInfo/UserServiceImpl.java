package com.li.service.userInfo;

import com.li.dao.UserInfoDao;
import com.li.dao.UserInfoImpl;
import com.li.pojo.UserInfo;
import com.li.util.BaseDao;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    private UserInfoDao userInfoDao;
    public UserServiceImpl(){
         userInfoDao = new UserInfoImpl();

    }

    public UserInfo login(String LoginName, String PassWord) {
        Connection conn=null;
        UserInfo userInfo=null;
        try {
            conn = BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作
            userInfo=userInfoDao.getLoginUser(conn,LoginName);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn,null,null);
        }
        //配对密码
        if(null!=userInfo){
            if(!userInfo.getPassWord().equals(PassWord)){
                userInfo=null;
            }
        }


        return userInfo;

     }

     @Test
    public void test(){
         UserServiceImpl userService = new UserServiceImpl();
         UserInfo login = userService.login("admin", "admin");

     }
}
