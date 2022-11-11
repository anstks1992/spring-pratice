<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
a2<br>

req_attr : ${req_attr}<br>
model_attr : ${modle_attr}<br>

<hr>

req_attr : <%=request.getParameter("req_attr") %><br>
model_attr : <%=request.getParameter("model_attr") %><br>