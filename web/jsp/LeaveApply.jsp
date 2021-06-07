<%@ page import="com.li.pojo.UserInfo" %>
<%@ page import="com.li.dao.UserInfoDao" %>
<%@ page import="com.li.util.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            margin: 0 auto;
            text-align: center;
            width: 600px;
            border: 1px;
            border-collapse: collapse;
            border: rgb(177, 175, 175);
        }

        td {
            height: 30px;
        }

        input,
        textarea {
            width: 90%;
            border: 1px solid rgb(177, 175, 175);
        }

        input:last-child {
            margin: 3px 0;
        }
    </style>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
</head>
<body>
<input type="hidden" id="LoginName" value="${LoginName}"/>
<form action="${pageContext.request.contextPath}/LeaveForm" method="POST">
    <table border="1">
        <tr>
           <input type="hidden" name="UserID" value="<%=Constants.USER_ID%>"/>
            <th colspan="4">申请请假</th>
        </tr>
        <tr>
            <td width="30%">标题</td>
            <td colspan="3">
                <input type="text" name="Title">
            </td>
        </tr>
        <tr>
            <td width="30%">开始日期</td>
            <td>
                <input type="date" name="BeginDate">
            </td>
            <td width="15%">结束日期：</td>
            <td>
                <input type="date" name="EndDate">
            </td>
        </tr>
        <tr>
            <td width="30%">请假原因</td>
            <td colspan="3">
                <textarea name="LeaveReason" id="" cols="30" rows="10"></textarea>
            </td>
        </tr>
        <tr>
            <td width="30%"> </td>
            <td colspan="3">
                <input type="submit" value="请假">
                <input type="button" value="退出" id="quiet" onclick="loginOut()">
            </td>
        </tr>
    </table>
</form>


<script>
function loginOut() {

    window.location.replace("${pageContext.request.contextPath}/LeaveOut");

}

</script>
</body>
</html>
