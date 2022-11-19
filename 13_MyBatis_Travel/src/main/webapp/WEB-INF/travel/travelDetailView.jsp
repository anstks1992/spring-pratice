<%@page import="travel.model.TravelBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
travelDetailView.jsp<br>
<h1 align="center">여행 상세 화면</h1>
<center>
<table border="1">
	<tr>
		<td>번호</td>
		<td>${travel.num }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=((TravelBean)request.getAttribute("travel")).getName() %>
</td>
		<%-- ${travel.name },${travel.getName() },
		${requestScope.travel.name} --%>
	</tr>
	<tr>
		<td>관심지역</td>
		<td>${travel.area }</td>
	</tr>
	<tr>
		<td>여행타입</td>
		<td>${travel.style }</td>
	</tr>
	<tr>
		<td>가격대</td>
		<td>${travel.price }</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="list.tv?pageNumber=${pageNumber}">여행 리스트 화면으로 돌아감</a>
		</td>
	</tr>
</table>
</center>

