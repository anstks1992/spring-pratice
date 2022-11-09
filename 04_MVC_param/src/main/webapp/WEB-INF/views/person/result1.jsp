<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    

name1: ${name} <br>
name2: ${param.name} <br> <!--parameter되는거  -->
name3: <%=request.getParameter("name") %><br><!--parameter되는거  -->
name4: <%=request.getAttribute("name") %><br>
<hr>
name10: ${name2} <br> <!-- 속성 되는거  -->
name11: ${param.name2} <br>
name12: <%=request.getParameter("name2") %><br>
name13: <%=request.getAttribute("name2") %><br> <!-- 속성 되는거  -->