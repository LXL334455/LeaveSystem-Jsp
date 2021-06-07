<%@ page import="com.li.service.leave.LeaveServiceImpl" %>
<%@ page import="com.li.pojo.Leave" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #searchInfo {
            display: flex;
            margin: 0 auto;
            width: 730px;
            border: 1px solid gray;
        }

        #searchInfo div {
            margin: 10px;
        }

        #searchInfo div:nth-last-child(2) input {
            vertical-align: -2px;
        }

        .leave-info {
            margin: 10px auto;
            width: 1200px;
            border-color: black;
            text-align: center;
            border-collapse: collapse;
        }

        .leave-info th {
            height: 35px;
            font-weight: 400;
            color: white;
            background-color: #008c8c;
        }

        .leave-info td {
            padding: 3px;
            height: 35px;
        }
    </style>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
</head>
<body>
<form id="searchInfo" action="">
    <div>
        申请人：
        <select name="proposer">
            <option value="xx">全部用户</option>
            <option value="xx">xxx</option>
        </select>
    </div>
    <div> <label for="title">标题</label>
        <input type="text" name="title" id="title">
    </div>
    <div>
        <span>审批状态：</span>
        <input type="radio" name="approval-status" value="未审批">未审批
        <input type="radio" name="approval-status" value="已审批">未审批
        <input type="radio" name="approval-status" value="全部" checked>全部
    </div>
    <div>
        <input type="submit" value="查询" form="searchInfo">
    </div>
</form>

<form action="${pageContext.request.contextPath}/LeaveDel" method="post">
    <table class="leave-info" border="1px">
        <tr>

            <th>申请人</th>
            <th>标题</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>申请时间</th>
            <th>审批状态</th>
            <th>审批时间</th>
            <th>审批结果</th>
            <th>操作</th>
        </tr>
        <%
            List<Leave> leaveList = LeaveServiceImpl.getLeaveList();
            request.setAttribute("leaveList",leaveList);
        %>

        <c:forEach items="${leaveList}" var="leave">

            <tr id="${leave.leaveID}">
                <td hidden><input id="LeaveID" type="hidden" value="${leave.leaveID}" name="LeaveID"></td>
                <td>${leave.userInfo.loginName}</td>
                <td>${leave.title}</td>
                <td>${leave.beginDate}</td>
                <td>${leave.endDate}</td>
                <td>${leave.applyTime}</td>
                <td>${leave.approveState==1?"未审批":"已审批"}</td>
                <td>${leave.approveTime}</td>
                <td>${leave.approveResult}</td>
                <td>
                    <input type="button" value="删除" class="btn" id="${leave.leaveID}">
                </td>
            </tr>
        </c:forEach>

    </table>
</form>

<script>

    let deleteButtons = document.querySelectorAll(".btn");
    console.log(deleteButtons);
    for (let i = 0; i < deleteButtons.length; i++) {
        deleteButtons[i].addEventListener("click",(event)=>{
            let id =event.target.id;
            console.log(id);

            $.ajax({
                url:"${pageContext.request.contextPath}/LeaveDel",
                type:"post",
                data:{"LeaveID":id},
                success:function (data) {
                    if(data.delResult=="true"){
                        console.log('已成功！')
                    }
                },
                error:function (data) {
                    console.log(data)
                }
            });
            event.target.parentNode.parentNode.remove()

        })
    }



</script>

</body>
</html>
