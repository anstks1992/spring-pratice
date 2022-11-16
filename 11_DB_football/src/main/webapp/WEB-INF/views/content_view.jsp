<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%
    String[] win = {"한국", "미국", "독일", "스페인"};
	String[] round16 = {"한국", "멕시코", "독일", "브라질", "스위스", "잉글랜드"};
%>

content_view.jsp(상세보기&수정폼)<br>
<form action="modify" method="post">
		<input type="hidden" name="num" size="50" value="${dto.num}">
		
		<table width="700" height="200" cellpadding="0" cellspacing="0" border="1" >
			<tr>
				<td>아이디</td>
				<td>${dto.id}</td>
			</tr>
			<tr>
				<td>비번</td>
				<td><input type="text" name="pw" size="50" value="${dto.pw}"></td>
			</tr>
			<tr>
				<td>우승예상국가</td>
				<td>
					<!-- 
					<input type="radio" name="win" value="한국">한국
					<input type="radio" name="win" value="미국">미국
					<input type="radio" name="win" value="독일">독일
					<input type="radio" name="win" value="스페인">스페인 
					-->
					<%-- ${dto.win} --%>
					<c:set var="win2" value="<%=win%>"/>
					<%-- 
					<c:forEach var="i" begin="0" end="${fn:length(win2)-1}">
						<input type="radio" name="win" value="${win2[i]}" <c:if test="${dto.win==win2[i]}">checked</c:if>>  ${win2[i]}
					</c:forEach>
					 --%>
					 
					<c:forEach var="nation" items="${win2 }">
					 	<input type="radio" name="win" value="${nation }" <c:if test="${dto.win eq nation}">checked</c:if>> ${nation }
					 </c:forEach>

					
				</td>
			</tr>
			<tr>
				<td>16강예상국가</td>
				<td>
				<!-- 	
				<input type="checkbox" name="round16" value="한국"/>한국
					<input type="checkbox" name="round16" value="멕시코">멕시코
					<input type="checkbox" name="round16" value="독일">독일
					<input type="checkbox" name="round16" value="브라질">브라질
					<input type="checkbox" name="round16" value="스위스">스위스
					<input type="checkbox" name="round16" value="잉글랜드">잉글랜드
					 -->
					 <%-- ${dto.round16 } 멕,브,일 --%>
					<c:set var="round16_2" value="<%=round16%>"/>
					<c:forEach var="i" begin="0" end="${fn:length(round16_2)-1}">
						<input type="checkbox" name="round16" value="${round16_2[i]}" <c:if test="${fn:contains(dto.round16,round16_2[i])}">checked</c:if> >${round16_2[i]}            
					</c:forEach>
					 
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정">
					&nbsp;&nbsp; 
				<a href="list">목록보기</a>
				<a href="delete?num=${dto.num}">삭제</a>
				</td>
			</tr>
		</table>
	</form>

