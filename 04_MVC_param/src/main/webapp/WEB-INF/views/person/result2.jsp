<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


id: ${param.id} <br> 
pw: ${param.pw} <br>
name: ${param.name} <br>
addr: ${param.addr} <br>

<hr>
id2: ${requestScope.pb.id}<Br>
id3: ${pb.id}<Br>
id4: ${pb.getId()}<Br>
id5: <%=((PersonBean)request.getAttribute("pb")).getId() %><br>

pw2:${requestScope.pb.pw }<br>
pw3:${pb.pw }<br>
pw4:${pb.getPw() }<br>
pw5:<%=((PersonBean)request.getAttribute("pb")).getPw() %><br>

name2:${requestScope.pb.name }<br>
name3:${pb.name }<br>
name4:${pb.getName() }<br>
name5:<%=((PersonBean)request.getAttribute("pb")).getName() %><br>

addr2:${requestScope.pb.addr }<br>
addr3:${pb.addr }<br>
addr4:${pb.getAddr() }<br>
addr5:<%=((PersonBean)request.getAttribute("pb")).getAddr() %><br>

