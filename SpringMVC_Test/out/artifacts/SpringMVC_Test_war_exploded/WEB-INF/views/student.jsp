<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2017/12/1
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addStudent" method="post">
   名字：<input type="text" name="name" /><br>
    性别：<input  type="text" name="sex" /><br>
    学号：<input  type="text" name="number" /><br>
    <input type="submit" value="提交" /><br>
</form>
</body>
</html>
