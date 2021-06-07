package com.li.servlet;

import com.li.pojo.Leave;
import com.li.pojo.UserInfo;
import com.li.service.leave.LeaveServiceImpl;
import org.apache.commons.lang3.time.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class LeaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String title = req.getParameter("Title");
            String beginDate = req.getParameter("BeginDate");
            Date begindate = DateUtils.parseDate(beginDate, "yyyy-MM-dd");
            String EndDate = req.getParameter("EndDate");
            Date enddate = DateUtils.parseDate(EndDate, "yyyy-MM-dd");
            String leaveReason = req.getParameter("LeaveReason");
            int userID = Integer.parseInt(req.getParameter("UserID"));
            //调业务层
            LeaveServiceImpl leaveService = new LeaveServiceImpl();

            Leave leave = new Leave();
            UserInfo userInfo = new UserInfo();
            userInfo.setUserID(userID);
            leave.setTitle(title);
            leave.setBeginDate(begindate);
            leave.setEndDate(enddate);
            leave.setLeaveReason(leaveReason);
            leave.setUserInfo(userInfo);

            boolean b = leaveService.addLeavePermit(leave);
            if(b){
                resp.sendRedirect("jsp/LeaveApply.jsp");
            }else{
                resp.getWriter().write("error");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }



}
