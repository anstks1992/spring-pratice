<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

views/form.jsp
<style>
.err{
  font-size:9pt;
  color:red;
  font-weight:bold;
}

</style>
<form:form commandName="mbean" action="form" method="post">
아이디 : <input type="text" name="id" value="${mbean.id }"> <!--value에 memberbean.id도 가능  -->
<form:errors cssClass="err" path="id"/>
<br><br>
비번 : <input type="text" name="pw" value="${mbean.pw }">
<form:errors cssClass="err" path="pw"/>
<br><br>

<input type="submit" value="전송">

</form:form>