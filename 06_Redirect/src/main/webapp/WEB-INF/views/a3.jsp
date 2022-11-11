<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
a3<br>

req_attr : ${req_attr}<br>
model_attr : ${model_attr}<br>
<!-- 어떤 요청을 거쳐서 오면 출력이 안된다 -->

<hr>


req_attr : <%=request.getParameter("req_attr") %><br>
model_attr : <%=request.getParameter("model_attr") %><br> <!-- 출력가능 -->