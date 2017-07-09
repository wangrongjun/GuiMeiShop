<%--
  Created by IntelliJ IDEA.
  User: wangrongjun
  Date: 2017/6/18
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min-3.2.0.css"/>
    <link rel="stylesheet" type="text/css" href="css/header_content_footer.css"/>
    <script src="js/jquery.min-1.9.0.js"></script>
    <script src="js/bootstrap.min-3.2.0.js"></script>
    <title>用户登录</title>
    <style type="text/css">
        content {
            background: url(img/bg_wood.jpg);
        }

        .ad {
            position: absolute;
            top: 150px;
            left: 50px;
            width: 700px;
            height: 300px;
        }

        .ad img {
            height: 100%;
            width: 100%;
        }

        .login_box {
            margin: 60px 100px 20px auto;
            width: 50%;
            max-width: 400px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px gray;
            background-color: rgba(238, 238, 238, 0.5);
        }

        #msg {
            margin-left: 20px;
            color: red;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"/>

<content>

    <div class="login_box">
        <center><h1>用户登录</h1></center>
        <form action="login.do" method="post" onsubmit="return checkInput()">
            <div class="form-group">
                <label>手机号：</label>
                <input type="number" class="form-control" name="phone" value="${phone}" placeholder="请输入手机号">
            </div>
            <div class="form-group">
                <label>密码：</label>
                <input type="password" class="form-control" name="password" value="${password}" placeholder="请输入密码">
            </div>
            <div class="form-group">
                <label>身份：</label> &nbsp;
                <label>
                    <input type="radio" name="identity" value="customer"
                           <c:if test="${identity!='seller'}">checked="checked"</c:if>>
                    客户
                </label> &nbsp;
                <label><input type="radio" name="identity" value="seller"
                              <c:if test="${identity=='seller'}">checked="checked"</c:if>>
                    商家</label>
            </div>
            <button type="reset" class="btn btn-default">重置</button>
            <button type="submit" class="btn btn-primary">登录</button>
            <span id="msg">${msg}</span>
        </form>
        <div style="position: relative; margin-top: 10px;">
            <a href="register.jsp">没有帐号，马上注册</a>
            <a href="#" style="position: absolute; right: 0;">忘记密码</a>
        </div>
    </div>

</content>

<jsp:include page="footer.jsp"/>

<script type="text/javascript">
    function checkInput() {
        if ($("[name='phone']").val() == "" || $("[name='password']").val() == "") {
            $("#msg").text("不能为空");
            return false;
        }
        return true;
    }
</script>

</body>
</html>
