<%--
    @author gp
    @create 2020/2/3 15:59
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<a href="hello">hello</a>
<br/>
<%--Rest风格的请求方式--%>
<form method="post" action="account">
    <input type="submit" value="增加账户"/>
</form>

<%--  发起put请求--%>
<form method="post" action="account/1">
    <input name="_method" value="put" type="hidden"/>
    <input type="submit" value="修改账户"/>
</form>

<%--  发起delete请求--%>
<form method="post" action="account/1">
    <input name="_method" value="delete" type="hidden"/>
    <input type="submit" value="删除账户"/>
</form>

<form method="get" action="account/1">
    <input type="submit" value="查询账户"/>
</form>
<br/>
<a href="paramHandler?user=wsc">获取请求参数</a><br/>
<form action="params" method="post">
    姓名:<input name="name"/><br/>
    卡号:<input name="cardid"/><%--<form:errors path="cardid"/>--%> <br/>
    余额:<input name="balance"/><br/>
    <input type="submit" value="提交"/><br/>
</form>
<br/>
<a href="output">测试原生API存值</a>
<br/>
<a href="springoutput">测试spring提供的存值</a><br/>
<a href="modelandview">测试ModeAndView存值</a><br/>
<a href="useforward">测试利用forward来解析视图</a><br/>
<a href="useredirect">测试利用redirect来解析视图</a><br/>
<a href="viewcontroller">测试在配置文件中跳转页面</a><br/>
<a href="testResponseBody">测试ResponseBody注解</a><br/>
<a href="interceptor">测试拦截器</a><br/>
<a href="testExceptoin?i=1">测试异常处理</a><br/>
<a href="testMyexception?username=admin">测试自定义异常</a><br/>
<form method="post" action="requestBody" enctype="multipart/form-data">
    <input name="name" value="gp"/>
    <input type="file" name="file"/>
    测试Request注解:<input type="submit" value="提交"/>
</form>
<br/>
<form method="post" action="httpEntity" enctype="multipart/form-data">
    <input name="name" value="gp"/>
    <input type="file" name="file"/>
    测试HttpEntity:<input type="submit" value="提交"/>
</form>
<br/>
</body>
</html>
