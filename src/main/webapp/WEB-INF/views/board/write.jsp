<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		
		<!-- name값이 BoardVO와 동일하여야함 -->
		<label>제목</label> <input type="text" name="title" /><br /> <label>작성자</label>
		<input type="text" name="writer" /><br /> <label>내용</label>
		<textarea cols="50" rows="5" name="content"></textarea>
		<br />

		<button type="submit">작성</button>

	</form>
</body>
</html>