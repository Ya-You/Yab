<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">
	<c:if test="${!empty message}">
		alert('${message}');
	</c:if>
	
</script>

</head>
<body>
	<c:remove var="message" scope="session"/>
	<div class="warpper"> 
		<div>
			<table border="1px">
			<tr align="center" style="font-size: 25px">图书信息</tr>
				<thead>
					<tr>
						<th width="150px" style="background-color: #ab1b34">图书ID</th>
						<th width="150px" style="background-color: #ab1b34">图书名称</th>
						<th width="100px" style="background-color: #ab1b34">图书作者</th>
						<th width="100px" style="background-color: #ab1b34">购买时间</th>
						<th width="100px" style="background-color: #ab1b34">图书分类</th>
						<th width="100px" style="background-color: #ab1b34">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookList}" var="book" varStatus="vs">
						<c:if test="${vs.index%2==0}">
							<tr>
						</c:if>
						<c:if test="${vs.index%2!=0}">
							<tr style="background-color: gray;">
						</c:if>
							<td>${book.bid}</td>
							<td>${book.bname}</td>
							<td>${book.bauthor}</td>
							<td>${book.btime}</td>
							<td>${book.getTypeStr()}</td>
							<td><a href="del?petId=${book.bid}">删除</a>
							<a href="info?petId=${book.bid}">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="Add.jsp">新增图书信息</a>
		</div>
	</div>
</body>
</html>