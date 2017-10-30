<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">
	function myAdd(){
		var petName = $("#petName").val();
		var petBreed = $("#petBreed").val();
		var birthday = $("#birthday").val();
		var petType=$("#petType").val();
		if(!petName){
			alert("名称不能为空!");
			return;
		}
		if(!petBreed){
			alert("作者名不能为空!");
			return;
		}
		if(!birthday){
			alert("购买日期不能为空!");
			return;
		}
		var reg = /^\d{4}-\d{2}-\d{2}$/;
		if(!reg.test(birthday)){
			alert("日期格式不正确");
			return;
		}
		if(!petType){
			alert("图书类别不能为空！");
			return;
		}
		$('#addForm').submit();
	}

</script>

<script type="text/javascript">
	<c:if test="${!empty message}">
		alert('${message}');
	</c:if>
</script>
</head>
<body>
<% String path=request.getContextPath(); %>
	<c:remove var="message" scope="session"/>
	<div align="center"><h2>图书基本信息</h2></div>
	<form id="addForm" action="add" method="post">
		<div align="center">
			<table>
				<tr>
					<td align="right">图书名称：</td>
					<td><input type="text" name="petName" id="petName"/></td>
				<tr>
				<tr>
					<td align="right">图书作者：</td>
					<td><input type="text" name="petBreed" id="petBreed"/></td>
				<tr>
				<tr>
					<td align="right">购买日期：</td>
					<td><input type="text" name="birthday" id="birthday"/>yyyy-mm-dd</td>
				<tr>
				
				<tr>
					<td align="right">图书类别：</td>
					<td>
						<select name="petType" id="petType">
						<option value="">选择所属分类</option>
						<option value="1">计算机/软件</option>
						<option value="2">小说、文摘</option>
						<option value="3">杂项</option>
					</select>
					</td>
				<tr>
				<tr>
					<td></td>
					<td>
						<input type="button" value="提交" onclick="myAdd();"/>
					</td>
				<tr>
			</table>
		</div>
	</form>
</body>
</html>