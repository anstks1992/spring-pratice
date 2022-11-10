<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

result2<br>

title: ${mb.title} <br> 
singer: ${mb.singer} <br> 
price: ${mb.price} <br> 

title: <%=request.getParameter("title") %><br>
singer: <%=request.getParameter("singer") %><br>
price: <%=request.getParameter("price") %><br>


