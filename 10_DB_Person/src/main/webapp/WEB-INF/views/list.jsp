<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 



 <table border="1" width="70%">
list.jsp<br> 
레코드갯수 : ${fn:length(lists)}
        <tr align="center">
            <td>번호</td>
            <td>아이디</td>
            <td>이름</td>
            <td>나이</td>
        </tr>
        <c:forEach items="${lists}" var="persondto">
            <tr align="center">
                <td>${persondto.num}</td>
                <td>${persondto.id}</td>
                <td><a href="content_view?num=${persondto.num}">${persondto.name}</a></td>
                <td>${persondto.age}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"> 
                <a href="javascript:history.go(-1)">돌아가기</a>
                 <a href="insertForm">삽입</a> <!-- 요청을 하기 때문에 뒤에 .jsp안붙힘  -->
            </td>
        </tr>
    </table>
     
     
     <%-- <c:forEach var="i" begin="0" end="${fn:length(lists)-1}" step="1" }>
            <tr align="center">
                <td>${lists[i].num}</td>
                <td>${lists[i].id}</td>
                <td>${lists[i].name}</td>
                <td>${lists[i].age}</td>
            </tr>
        </c:forEach> --%>
    
