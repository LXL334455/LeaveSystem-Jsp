package com.li.pojo;

import java.util.Date;

public class Leave {
    private Integer LeaveID;
    private String Title;
    private Date BeginDate;
    private Date  EndDate;
    private String LeaveReason;
    private Date  ApplyTime;
    private Integer ApproveState;
    private Date   ApproveTime;
    private String ApproveResult;
    private UserInfo userInfo;

    public Leave() {
    }

    public Leave(Integer leaveID, String title, Date beginDate, Date endDate, String leaveReason, Date applyTime, Integer approveState, Date approveTime, String approveResult, UserInfo userInfo) {
        LeaveID = leaveID;
        Title = title;
        BeginDate = beginDate;
        EndDate = endDate;
        LeaveReason = leaveReason;
        ApplyTime = applyTime;
        ApproveState = approveState;
        ApproveTime = approveTime;
        ApproveResult = approveResult;
        this.userInfo = userInfo;
    }

    public Integer getLeaveID() {
        return LeaveID;
    }

    public void setLeaveID(Integer leaveID) {
        LeaveID = leaveID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(Date beginDate) {
        BeginDate = beginDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getLeaveReason() {
        return LeaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        LeaveReason = leaveReason;
    }

    public Date getApplyTime() {
        return ApplyTime;
    }

    public void setApplyTime(Date applyTime) {
        ApplyTime = applyTime;
    }

    public Integer getApproveState() {
        return ApproveState;
    }

    public void setApproveState(Integer approveState) {
        ApproveState = approveState;
    }

    public Date getApproveTime() {
        return ApproveTime;
    }

    public void setApproveTime(Date approveTime) {
        ApproveTime = approveTime;
    }

    public String getApproveResult() {
        return ApproveResult;
    }

    public void setApproveResult(String approveResult) {
        ApproveResult = approveResult;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "LeaveID=" + LeaveID +
                ", Title='" + Title + '\'' +
                ", BeginDate=" + BeginDate +
                ", EndDate=" + EndDate +
                ", LeaveReason='" + LeaveReason + '\'' +
                ", ApplyTime=" + ApplyTime +
                ", ApproveState=" + ApproveState +
                ", ApproveTime=" + ApproveTime +
                ", ApproveResult='" + ApproveResult + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
