<%--
@author gp
@create 2020/2/4 10:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>output</title>
</head>
<body>
Session : ${sessionScope.sessionValue}<br/>
Request : ${requestScope.requestValue}<br/>
Maprequest : ${requestScope.mapkey}<br/>
Modelrequest : ${requestScope.modelkey}<br/>
ModelMaprequest : ${requestScope.modelMapkey}<br/>
ModelAndViewrequest : ${modelandviewKEY}<br/>
ModelAndViewsession : ${sessionScope.modelandviewKEY}
</body>
</html>
