<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
title: ${inp.getTitle()}<br> 
singer: ${inp.singer}<br>
price: ${requestScope.inp.price}<br>
price2: <%=((MusicBean)request.getAttribute("inp")).getPrice() %><br>       