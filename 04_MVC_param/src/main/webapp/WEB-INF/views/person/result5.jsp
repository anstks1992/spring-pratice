<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

join5<br>

id: ${per.id}<br> 
pw: ${per.pw}<br>
name: ${per.name}<br>
addr: ${per.addr}<br>

id2: ${per.getId()}<br> 
     ${param.id}<br>
pw2: ${per.pw}<br>
name2: ${requestScope.per.name}<br>
addr2: <%=((PersonBean)request.getAttribute("per")).getAddr() %><br>