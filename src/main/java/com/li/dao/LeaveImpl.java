package com.li.dao;

import com.li.pojo.Leave;
import com.li.pojo.UserInfo;
import com.li.util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveImpl implements LeaveDao{

    public int addLeavePermit(Connection conn, Leave leave) throws Exception {
        PreparedStatement pstm=null;
        int updateRows=0;
        if(conn!=null){
            String sql="INSERT into `leave`(Title,BeginDate,EndDate,LeaveReason,UserID) values(?,?,?,?,?)";
            Object[] params={
                    leave.getTitle(),
                    leave.getBeginDate(),
                    leave.getEndDate(),
                    leave.getLeaveReason(),
                    leave.getUserInfo().getUserID()
            };
            updateRows=BaseDao.queryUpdate(conn,pstm,sql,params);
        }



        return updateRows;
    }

    public int deleteLeavePermit(Connection conn,Integer LeaveID) throws Exception {
        PreparedStatement pstm=null;
        int flag=0;
        if(conn!=null){
            String sql="DELETE from `leave`  WHERE LeaveID=?";
            Object[]params={LeaveID};
            flag= BaseDao.queryUpdate(conn,pstm,sql,params);
            BaseDao.closeResource(null,null,pstm);
        }
        return flag;
    }

    /** public List<Leave> getLeaveList(Connection conn) {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Leave> leaveList = new ArrayList<Leave>();
        Leave leave = new Leave();
        UserInfo userInfo = new UserInfo();
        if(conn!=null){
            String sql="SELECT `user`.LoginName,L.Title,L.BeginDate,L.EndDate,L.ApplyTime,L.ApproveState,L.ApproveTime,L.ApproveResult\n" +
                    "FROM userinfo `user`,`leave` L WHERE `user`.UserID=L.UserID;";
            Object[]params=null;
            try {
                rs=BaseDao.queryInquire(conn,pstm,rs,sql,params);
                while (rs.next()){
                    userInfo.setLoginName(rs.getString("LoginName"));
                    leave.setUserInfo(userInfo);
                    leave.setTitle(rs.getString("Title"));
                    leave.setBeginDate(rs.getDate("BeginDate"));
                    leave.setEndDate(rs.getDate("EndDate"));
                    leave.setApplyTime(rs.getDate("ApplyTime"));
                    leave.setApproveState(rs.getInt("ApproveState"));
                    leave.setApproveTime(rs.getDate("ApproveTime"));
                    leave.setApproveResult(rs.getString("ApproveResult"));

                    leaveList.add(leave);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(null,rs,pstm);
            }


        }
        return leaveList;
    }*/
}
