package com.li.dao;

import com.li.pojo.UserInfo;
import com.li.util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoImpl implements UserInfoDao{


    public UserInfo getLoginUser(Connection conn, String LoginName) {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        UserInfo userInfo=null;
        if(conn!=null){
            String sql="select * from leavemanage.userinfo where LoginName=? ";
            Object[]params={LoginName};
            try {
                rs=BaseDao.queryInquire(conn,pstm,rs,sql,params);
                while(rs.next()){
                    userInfo = new UserInfo();
                    userInfo.setUserID(rs.getInt("UserID"));
                    userInfo.setLoginName(rs.getString("LoginName"));
                    userInfo.setPassWord(rs.getString("PassWord"));
                    userInfo.setUserRole(rs.getInt("UserRole"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(null,rs,pstm);
            }

        }
        return userInfo;
    }
}
