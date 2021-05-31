<%--
  Created by IntelliJ IDEA.
  User: 91320
  Date: 2021/5/23
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--输出,条件,迭代标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> <!--数据格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%> <!--数据库相关标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> <!--常用函数标签库-->
<%@ page isELIgnored="false"%> <!--支持EL表达式，不设的话，EL表达式不会解析-->

<html>
<head>
    <title>Show</title>
</head>
<body>
<h3>有 ${LineError}处行间距错误</h3>
<h3>
    <c:forEach items="${errmsg}" var="temp" >
       <h3>${temp}</h3>
    </c:forEach>

</h3>
</body>
</html>
