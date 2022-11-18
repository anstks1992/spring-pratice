<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
.err{
  font-size:9pt;
  color:red;
  font-weight:bold;
}

</style>
 <form:form commandName="album" action="insert.ab" method="post" >  
<h1>앨범 추가 화면</h1>
<p>
    <label>노래제목</label>
    <input type="text" name="title" value="${album.title} ">
    <form:errors cssClass="err" path="title"/>
</p>
<p>
    <label>가수명</label>
    <input type="text" name="singer" value="${album.singer}">
    <form:errors cssClass="err" path="singer"/>
</p>
<p>
    <label>가격</label>
    <input type="text" name="price" value="${album.price}">
     <form:errors cssClass="err" path="price"/>
</p>
<p>
    <label>발매일</label>
    <input type="text" name="day" value="2022-3-1">
    <form:errors cssClass="err" path="day"/>
</p>
<p>
    <input type="submit" value="추가하기">
</p>
</form:form>