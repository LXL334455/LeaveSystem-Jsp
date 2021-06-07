package com.li.dao;

import com.li.pojo.Leave;

import java.sql.Connection;
import java.util.List;

public interface LeaveDao {

    //新增假条
    public int addLeavePermit(Connection conn, Leave leave) throws Exception;
    //查询所有假条
//    public List<Leave> getLeaveList(Connection conn, String LoginName, String Title, Date BeginDate,Date EndDate,Date ApplyTime,Integer ApproveState,Date ApproveTime,String ApproveResult);
//    public List<Leave> getLeaveList(Connection conn);

    //删除假条
    int deleteLeavePermit(Connection conn,Integer LeaveID) throws Exception;

}
