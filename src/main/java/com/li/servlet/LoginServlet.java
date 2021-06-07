package com.li.servlet;

import com.li.pojo.UserInfo;
import com.li.service.userInfo.UserServiceImpl;
import com.li.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //控制层调业务层代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String loginName = req.getParameter("LoginName");
        String passWord = req.getParameter("PassWord");
        //和数据库中的密码进行比对,调业务层
        UserServiceImpl userService = new UserServiceImpl();
        UserInfo login = userService.login(loginName, passWord);

        //对比是否账号存在
        if(login!=null){
            req.getSession().setAttribute("LoginName",login.getLoginName());
            if(login.getUserRole()==1){
                Constants.USER_ID=login.getUserID();
                resp.sendRedirect("jsp/LeaveList.jsp");
            }else if(login.getUserRole()==2){
                Constants.USER_ID=login.getUserID();
                // resp.sendRedirect("jsp/LeaveApply.jsp");
                req.getRequestDispatcher("jsp/LeaveApply.jsp").forward(req,resp);
            }
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}

