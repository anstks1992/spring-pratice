<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

name1: ${name1} <br> 
name2: ${name2} <br>

name3: ${requestScope.name1} <br> 
name4: ${requestScope.name2} <br>

name5: <%=request.getAttribute("name1") %><br> 
name6: <%=request.getAttribute("name2") %><br>