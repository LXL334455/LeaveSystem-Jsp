package com.li.service.leave;

import com.li.dao.LeaveDao;
import com.li.dao.LeaveImpl;
import com.li.pojo.Leave;
import com.li.pojo.UserInfo;
import com.li.util.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaveServiceImpl implements LeaveService {
    private  LeaveDao leavedao;
    private static Connection conn=null;
    private static PreparedStatement pstm=null;
    private static ResultSet rs=null;
    public LeaveServiceImpl() {
        leavedao = new LeaveImpl();
    }
    //新增请假
    public boolean addLeavePermit(Leave leave) {
        boolean flag=false;
        Connection conn=null;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);//开启JDBC事务
            int updateRows=leavedao.addLeavePermit(conn,leave);
            conn.commit();
            if(updateRows>0){
                flag=true;
                System.out.println("Add Successful");
            }else{
                System.out.println("Add Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            BaseDao.closeResource(conn,null,null);
        }


        return flag;


    }


    //查询所有请假
    public static List<Leave> getLeaveList() {
        List<Leave> leaveList = new ArrayList<Leave>();
        try {
            conn=BaseDao.getConnection();
            String sql="SELECT L.LeaveID,`user`.LoginName,L.Title,L.BeginDate,L.EndDate,L.ApplyTime,L.ApproveState,L.ApproveTime,L.ApproveResult\n" +
                    "FROM userinfo `user`,`leave` L WHERE `user`.UserID=L.UserID;";
            pstm=conn.prepareStatement(sql);
            rs= pstm.executeQuery();
            while (rs.next()){
                Leave leave = new Leave();
                UserInfo userInfo = new UserInfo();
                leave.setLeaveID(rs.getInt("LeaveID"));
                userInfo.setLoginName(rs.getString("LoginName"));
                leave.setUserInfo(userInfo);
                leave.setTitle(rs.getString("Title"));
                leave.setBeginDate(rs.getTimestamp("BeginDate"));
                leave.setEndDate(rs.getTimestamp("EndDate"));
                leave.setApplyTime(rs.getTimestamp("ApplyTime"));
                leave.setApproveState(rs.getInt("ApproveState"));
                leave.setApproveTime(rs.getTimestamp("ApproveTime"));
                leave.setApproveResult(rs.getString("ApproveResult"));
                leaveList.add(leave);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(null,rs,pstm);
        }


        return leaveList;
    }

    public boolean deleteLeavePermit(Integer LeaveID) {
            Connection conn=null;
            boolean flag=false;
        try {
            conn=BaseDao.getConnection();
            if(leavedao.deleteLeavePermit(conn,LeaveID)>0){
                flag=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn,null,null);
        }

        return flag;
    }
}
