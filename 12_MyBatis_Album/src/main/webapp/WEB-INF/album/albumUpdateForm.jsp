<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%><!-- 지시어 = 복사  -->
                                        <!-- 자주쓰는 지시어들은 폴더를 따로 만들고 필요할때 가져오는 방법으로 사용할 수 있다   -->

<style type="text/css">
.err{
	color:red;
	font-weight: bold;
	font-size: 9pt;
}
</style>
        
albumUpdateForm.jsp (페이지번호: ${pageNumber} )<br>
<form:form commandName="album" action="update.ab" method="post">
	<input type="hidden" name="num" value="${album.num }">
	<input type="hidden" name="pageNumber" value="${pageNumber }">
	
	<h1>앨범 수정 화면</h1>
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="${album.title }">
		<form:errors path="title" cssClass="err"/>
	
	</p>
	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="${album.singer }">
		<form:errors cssClass="err" path="singer"/>
		
	</p>
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${album.price }">
		<form:errors cssClass="err" path="price"/>
	</p>
	<p>
		<label>발매일</label>
		<!-- 날짜 설정안하면 에러 발생  -->
		 <fmt:parseDate var ="parseDateDay" value="${album.day }" pattern="yyyy-MM-dd"></fmt:parseDate>
		<fmt:formatDate var="formatDateDay" value="${parseDateDay}" pattern="yyyy-MM-dd"></fmt:formatDate>
	   <input type="text" name="day" value="${formatDateDay}">
	   
	   ${formatDateDay}
	</p>
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>
