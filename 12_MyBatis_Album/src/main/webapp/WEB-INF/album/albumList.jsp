<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
	function insert(){
		//alert(1);
		location.href="insert.ab";
	}
	
	function goUpdate(num,pageNumber){
		alert(num+","+pageNumber);
		location.href="update.ab?num="+num+"&pageNumber="+pageNumber;
		// update.ab?num=5&pageNumber=3 
	}

</script>
album\albumList.jsp<br>

<h2 align="center">상품 리스트 화면(레코드 갯수:${totalCount })</h2>
<center>
	<form method="get" action="list.ab">
		<select name="whatColumn">
			<option value="all">전체검색
			<option value="title">노래제목
			<option value="singer">가수명
		</select>
		<input type="text" name="keyword" value="아이유">
		<input type="submit" value="검색">
		<!-- whatColumn=singer keyword=b -->
	</form>
</center>
<table border="1" align="center">
	<tr>
		<td colspan="7" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>노래제목</th>
		<th>가수명</th>
		<th>가격</th>
		<th>발매일</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="album" items="${albumList}">
		<tr>
			<td>${album.num}</td>
			<td>${album.title}</td>
			<td>${album.singer}</td>
			<td>${album.price}</td>
			<td>  <!-- 날짜 설정안하면 에러 발생  -->
			   <fmt:parseDate var ="parseDateDay" value="${album.day }" pattern="yyyy-MM-dd"></fmt:parseDate>
			   <fmt:formatDate var="formatDateDay" value="${parseDateDay}" pattern="yyyy-MM-dd"></fmt:formatDate>
			   ${formatDateDay}
			</td>
			<td>
				<a href="delete.ab?num=${album.num}&pageNumber=${pageInfo.pageNumber}">삭제</a>
			</td>
			<td>
				<input type="button" value="수정" onClick="goUpdate('${album.num}','${pageInfo.pageNumber}')">
			</td>
		</tr>
	</c:forEach>

</table>

<br>
<center>
	${pageInfo.pagingHtml}
	<%-- ${pageInfo.getPagingHtml()} --%>
</center>




