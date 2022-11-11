package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
    //@NotEmpty( message = "아이디 입력 누락") pom.xml에 dependency 추가해서 import되게 하기
	//@NotBlank(message = "아이디 입력 누락2")
	//@NotNull(message = "아이디 입력 누락2") 이건 안됨
	//@Length(min =3, max = 5, message = "3이상~5이하")
	@Size(min =4, max = 6,message = "4이상~6이하")
	private String id;
    
    @NotEmpty( message = "비번 입력 누락")
	private String pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
