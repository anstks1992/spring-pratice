<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
   <style>
.err{
  font-size:9pt;
  color:red;
  font-weight:bold;
}
</style>
<% 
	String[] areaArr = {"유럽","동남아","일본","중국"};
	String[] styleArr = {"패키지","크루즈","자유여행","골프여행"};
	String[] priceArr = {"100~200","200~300","300~400","400~500"};

%>    
travelUpdateForm.jsp<br>
<h2>여행 정보 수정 화면(페이지: ${pageNumber })</h2>
<form:form  commandName="travel"  action="update.tv" method="post">
	<input type="hidden" name="num" value="${travel.num}"> 
	<input type="hidden" name="pageNumber" value="${pageNumber}"> 
	이름 <input type="text" name="name" value="${travel.name}"> 
	<form:errors cssClass="err" path="name"/>
	
	<br><br>
	나이 <input type="text" name="age" value="${travel.age}"	> 
	<form:errors cssClass="err" path="age"/>
	<br><br>
	관심지역
	<!-- 
	<input type="checkbox" name="area" value="유럽">유럽
	<input type="checkbox" name="area" value="동남아">동남아
	<input type="checkbox" name="area" value="일본">일본
	<input type="checkbox" name="area" value="중국">중국  
	-->   
	<c:set var="areaList" value="<%=areaArr %>"/>    
	<c:forEach var="i" begin="0" end="${fn:length(areaList)-1 }">  
		<input type="checkbox" name="area" value="${areaList[i] }" <c:if test="${fn:contains(travel.area,areaList[i])}">checked</c:if>>${areaList[i] }
	</c:forEach>  
	<form:errors cssClass="err" path="area"/>
	<br><br>
	여행타입
	<!-- 
	<input type="radio" name="style" value="패키지">패키지
	<input type="radio" name="style" value="크루즈">크루즈
	<input type="radio" name="style" value="자유여행">자유여행
	<input type="radio" name="style" value="골프여행">골프여행
	 -->
	 
	<c:forEach var="style" items="<%=styleArr %>">
		<input type="radio" name="style" value="${style }" <c:if test="${style eq travel.style }">checked</c:if> >${style }
	</c:forEach>
	<form:errors cssClass="err" path="style"/>
	<br><br>
	
	가격
	<select name="price">
		<option value="">선택하세요
		<!-- 
		<option value="100~200">100~200
		<option value="200~300">200~300
		<option value="300~400">300~400
		<option value="400~500">400~500
		 -->
		<c:set var="priceArr" value="<%= priceArr %>"/>
		<c:forEach var="price" items="${priceArr}">
			<option value="${price }" <c:if test="${travel.price == price }"> selected </c:if> >${price }
		</c:forEach>
	</select>
	<form:errors cssClass="err" path="price"/>
	<br><br>
	<input type="submit" value="수정하기">
	<br><br>
</form:form>

