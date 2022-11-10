<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
result6<br>

title : ${mb.title}<br>
singer : ${requestScope.mb.title}<br>
price : <%=((MusicBean)request.getAttribute("mb")).getPrice() %><br> 