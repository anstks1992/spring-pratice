<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

result3<br>

title1: ${requestScope.mb.title}<Br>
title2: ${mb.title}<Br>
title3: ${mb.getTitle()}<Br>
title4: <%=((MusicBean)request.getAttribute("mb")).getTitle() %><br>

singer1: ${requestScope.mb.singer}<Br>
singer2: ${mb.singer}<Br>
singer3: ${mb.getSinger()}<Br>
singer4: <%=((MusicBean)request.getAttribute("mb")).getSinger() %><br>

price1: ${requestScope.mb.price}<Br>
price2: ${mb.price}<Br>
price3: ${mb.getPrice()}<Br>
price4: <%=((MusicBean)request.getAttribute("mb")).getPrice() %><br>