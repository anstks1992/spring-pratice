<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>

<script type="text/javascript">
	function insert(){
		//alert(1);
		location.href="insert.tv"; //get
	}
	function goUpdate(num,pageNumber){
		//alert(num+","+pageNumber);
		location.href="update.tv?num="+num+"&pageNumber="+pageNumber;
	}
	
</script>
<h2 align="center">상품 리스트 화면(레코드 갯수:${totalCount })</h2>
<center>
	<form method="get" action="list.tv">
		<select name="whatColumn">
			<option value="all">전체검색
			<option value="area">관심지역
			<option value="style">여행타입
		</select>
		<input type="text" name="keyword"value="유럽">
		<input type="submit" value="검색">
	</form>
</center>
<table border="1" align="center">	
    <tr>
		<td colspan="8" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>관심지역</th>
		<th>여행타입</th>
		<th>에상비용</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="travel" items="${travelLists}">
		<tr>
			<td>${travel.num}</td>
			<td>
			<a href="detail.tv?num=${travel.num}&pageNumber=${pageInfo.pageNumber}">${travel.name}</a>
			</td>
			<td>${travel.age}</td>
			<td>${travel.area}</td>
			<td>${travel.style}</td>
			<td>${travel.price}</td>
			<td>
			<a href="delete.tv?num=${travel.num}&pageNumber=${pageInfo.pageNumber}">삭제</a>
			<!-- pageNumber=${pageInfo.pageNumber}는 원래있던 페이지로 돌아가게 하는 설정  -->
			</td>
			<td>
			  <input type="button" value="수정" onClick="goUpdate('${travel.num}','${pageInfo.pageNumber}')">
			</td>
		</tr>
	</c:forEach>

</table>
<br>
<center>
	${pageInfo.pagingHtml}
</center>