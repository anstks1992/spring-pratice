<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
list.jsp
<br>

<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비번</td>
		<td>우승예상국가</td>
		<td>16강예상국가</td>
	</tr>
	<c:forEach var="i" begin="0" end="${fn:length(list)}" step="1">
		<tr>
			<td>${list[i].num }</td>
			<td><a href="content_view?num=${list[i].num }">${list[i].id }</a></td>
			<td>${list[i].pw }</td>
			<td>${list[i].win }</td>
			<td>${list[i].round16 }</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5">
			<a href="javascript:history.go(-1)">돌아가기</a>
	 		<a	href="writeform">삽입</a>
	 	</td>
	</tr>
</table>

