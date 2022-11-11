package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

//		Consumer�� name�� ö��
//		car�� Morning
//		
//		getName() : ö�� ���
//		personDrive() ȣ�� "Morning-Drive" ���
		
//		Consumer con=new Consumer();
//		Car mo=new Morning();
//		
//		con.setName("ö��");
//		con.setCar(mo);
//		System.out.println(con.getName());
//		System.out.println(con.personDrive());
		
		ApplicationContext context = new GenericXmlApplicationContext("app2.xml");
		
		
		Consumer con = context.getBean("consumer", Consumer.class);
		con.setName("ö��");

		System.out.println(con.getName());
		System.out.println(con.personDrive());
	}
}
