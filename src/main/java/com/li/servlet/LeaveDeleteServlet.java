package com.li.servlet;

import com.li.service.leave.LeaveServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import com.alibaba.fastjson.JSONArray;

public class LeaveDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int leaveID = Integer.parseInt(req.getParameter("LeaveID"));

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(leaveID<=0){
            resultMap.put("delResult","notexist");
        }else {
            LeaveServiceImpl leaveService = new LeaveServiceImpl();

            boolean b = leaveService.deleteLeavePermit(leaveID);
            System.out.println(b);

            if(b){
                System.out.println(leaveID);
                resultMap.put("delResult","true");
//                resp.sendRedirect("jsp/LeaveList.jsp");
            }else{
                resultMap.put("delResult","false");
            }
        }

        //将resultMap转换成Json对象输出
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(JSONArray.toJSONString(resultMap));
        writer.flush();
        writer.close();


    }
}
