<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "../include/header.jsp" %>

<section>
	<div align="center">
		<h3>MVC1 로그인연습</h3>
		<form action ="login_ok.jsp" method="post">
			<input type="text" name="id" placeholder="아이디" required><br>
			<input type="password" name="pw" placeholder="비밀번호" required><br>
			<input type="submit" value="로그인" class="btn btn-default">
			<input type="button" value="취소" class="btn btn-danger"onclick="location.href='join.jsp'">
			
		</form>
	</div>

</section>