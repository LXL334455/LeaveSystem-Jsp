<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table align="center" border="1px">
        <tr>
            <td><label>登录名：</label></td>
            <td><input type="text" name="LoginName"></td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td><input type="password" name="PassWord"></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
