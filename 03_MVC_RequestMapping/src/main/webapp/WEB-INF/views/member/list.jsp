<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
member/list.jsp<br>

id: ${id} <br> 
pw: ${pw} <br>

id2: ${requestScope.id} <br> 
pw2: ${requestScope.pw} <br>

id3: <%=request.getAttribute("id") %><br> 
pw3: <%=request.getAttribute("pw") %><br>