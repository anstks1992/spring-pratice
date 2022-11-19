<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<style>
.err{
  font-size:9pt;
  color:red;
  font-weight:bold;
}
</style>
<form:form commandName="travel"  method="post"  action="insert.tv">
<h1>여행 추가 화면</h1>
<p>
    <label>이름</label>
    <input type="text" name="name" >
     <form:errors cssClass="err" path="name"/>
</p>
<p>
    <label>나이</label>
    <input type="text" name="age" >
    <form:errors cssClass="err" path="age"/>

</p>
<p>
        <label>관심지역</label>
        <input type="checkbox" name="area"  value="유럽">유럽
        <input type="checkbox" name="area"  value="동남아">동남아
        <input type="checkbox" name="area"  value="일본">일본
        <input type="checkbox" name="area"   value="중국">중국
        <form:errors cssClass="err" path="area"/>
</p>
    
 <p>
        <label>여행 타입</label>
        <input type="radio" name="style"  value="패키지">패키지
        <input type="radio" name="style"  value="크루즈">크루즈
        <input type="radio" name="style"  value="자유여행">자유여행
        <input type="radio" name="style"  value="골프여행">골프여행
        <form:errors cssClass="err" path="style"/>
  </p>
    
  <p>
        <label>가격</label>
        
        <select name = "price">
            <option value="">선택하세요</option>
            <option value="100~200">100~200</option>
            <option value="200~300">200~300</option>
            <option value="300~400">300~400</option>
            <option value="400~500">400~500</option>
            <form:errors cssClass="err" path="price"/>
        </select>
    
    </p>

<p>
    <input type="submit" value="추가하기">
</p>
</form:form>