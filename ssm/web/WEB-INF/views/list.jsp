<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    @author gp
    @create 2020/2/6 11:17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
</head>
<%
    String path = request.getContextPath();
%>

<%--加上 / 后,会从web目录下找资源,而不是在本目录下找资源--%>
<link href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="<%=path %>/static/jquery/jquery-3.4.1.js"/>
<script src="<%=path %>/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function click1() {
        var pageNumber = document.getElementById("pageNumber").value;
        if (pageNumber == "") {
            alert("请输入页码!")
            return false;
        }
        if (pageNumber > ${pageinfo.pages}) {
            alert("请输入正确的页码数!")
            return false
        }
        document.form.submit();
    };

    function click2() {
        alert("这个功能还没来得及写!");
    };

    function click3(empName, empId) {
        if (confirm("您确定要删除" + empName + "吗?")) {
            window.location.href = "<%=path%>/emp/" + empId;
        }
    }
</script>
<body>
<div class="container">
    <%--    显示标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1 style="color: #f900bf">SSM三大开源框架整合</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 col-md-offset-10">
            <button type="button" class="btn btn-primary" onclick="click2()">新增</button>
            <button type="button" class="btn btn-danger">删除</button>
        </div>
    </div>
    <%--    显示表格--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>
                        <input type="checkbox"/>
                    </th>
                    <th>员工编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>邮箱</th>
                    <th>所在部门</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageinfo.list}" var="emp">
                <tr>
                    <th>
                        <input type="checkbox"/>
                    </th>
                    <th>${emp.id}</th>
                    <th>${emp.name}</th>
                    <th>${emp.gender==1?"男":"女"}</th>
                    <th>${emp.email}</th>
                    <th>${emp.dept.name}</th>
                    <th>
                        <button type="button" class="btn btn-info btn-sm">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                            编辑
                        </button>
                        <button type="button" class="btn btn-danger btn-sm" onclick="click3('${emp.name}','${emp.id}')">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            删除
                        </button>
                    </th>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </div>
    <%--    显示分页信息--%>
    <div class="row">
        <div class="col-md-6">
            当前第${pageinfo.pageNum}页,一共${pageinfo.pages}页,总员工人数有${pageinfo.total}人
        </div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="<%=path%>/emps?pageno=1">首页</a></li>
                    <li>
                        <c:if test="${pageinfo.hasPreviousPage}">
                            <a href="<%=path%>/emps?pageno=${pageinfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </c:if>
                    </li>
                    <c:forEach items="${pageinfo.navigatepageNums}" var="pageNum">
                        <c:if test="${pageNum == pageinfo.pageNum}">
                            <li class="active"><a href="<%=path%>/emps?pageno=${pageNum}">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageNum != pageinfo.pageNum}">
                            <li><a href="<%=path%>/emps?pageno=${pageNum}">${pageNum}</a></li>
                        </c:if>
                    </c:forEach>
                    <li>
                        <c:if test="${pageinfo.hasNextPage}">
                            <a href="<%=path%>/emps?pageno=${pageinfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </c:if>

                    </li>
                    <li><a href="<%=path%>/emps?pageno=${pageinfo.pages}">尾页</a></li>
                </ul>
            </nav>
            <form action="<%=path%>/emps" name="form">
                转到第 <input name="pageno" size="3" id="pageNumber"/> 页
                <input type="button" onclick="click1()" value="提交">
            </form>
        </div>
    </div>
</div>
</body>
</html>
