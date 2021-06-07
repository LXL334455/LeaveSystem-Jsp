package com.li.service.leave;

import com.li.pojo.Leave;

import java.util.List;

public interface LeaveService {
    public boolean addLeavePermit(Leave leave);
//    public  List<Leave> getLeaveList();
    public boolean deleteLeavePermit(Integer LeaveID);

}
