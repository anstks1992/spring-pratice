<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	write_view.jsp<br><br>
	<form action="write" method="post">
		<table width="700" height="200" cellpadding="0" cellspacing="0" border="1" >
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="50"></td>
			</tr>
			<tr>
				<td>비번</td>
				<td><input type="text" name="pw" size="50"></td>
			</tr>
			<tr>
				<td>우승예상국가</td>
				<td>
					<input type="radio" name="win" value="한국">한국
					<input type="radio" name="win" value="미국">미국
					<input type="radio" name="win" value="독일">독일
					<input type="radio" name="win" value="스페인">스페인
				</td>
			</tr>
			<tr>
				<td>16강예상국가</td>
				<td>
					<input type="checkbox" name="round16" value="한국"/>한국
					<input type="checkbox" name="round16" value="멕시코">멕시코
					<input type="checkbox" name="round16" value="독일">독일
					<input type="checkbox" name="round16" value="브라질">브라질
					<input type="checkbox" name="round16" value="스위스">스위스
					<input type="checkbox" name="round16" value="잉글랜드">잉글랜드
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="입력">
					&nbsp;&nbsp; 
				<a href="list">목록보기</a></td>
			</tr>
		</table>
	</form>

</body>
</html>
