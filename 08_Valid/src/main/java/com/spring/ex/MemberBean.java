package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
    //@NotEmpty( message = "���̵� �Է� ����") pom.xml�� dependency �߰��ؼ� import�ǰ� �ϱ�
	//@NotBlank(message = "���̵� �Է� ����2")
	//@NotNull(message = "���̵� �Է� ����2") �̰� �ȵ�
	//@Length(min =3, max = 5, message = "3�̻�~5����")
	@Size(min =4, max = 6,message = "4�̻�~6����")
	private String id;
    
    @NotEmpty( message = "��� �Է� ����")
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
