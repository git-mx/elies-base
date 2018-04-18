<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
</head>
<body>
<script type="text/javascript" src="static/jquery-1.11.3.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        alert('11111111111');
    });
    function test(){
        var userLogin = {
            loginName:'mx',
            loginPassword:'123456'
        }
        $.ajax({
            type: "POST",
            url: "<%=basePath%>/user/interface",
            data: JSON.stringify(userLogin),
            dataType: "json",
            contentType:"application/json;charset=UTF-8",
            success: function(data){
                console.log(data);
            }
        });
    }
</script>
<form action="<%=basePath%>/user/goto.do">
    <table border="1">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="loginName"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="loginPassword"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
        <tr>
            <td>
                <input type="button" onclick="test()" value="测试ajax" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>