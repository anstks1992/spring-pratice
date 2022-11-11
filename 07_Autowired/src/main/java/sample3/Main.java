package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

//		ConsumerÀÇ name¿¡ Ã¶¼ö
//		car¿¡ Morning
//		
//		getName() : Ã¶¼ö Ãâ·Â
//		personDrive() È£Ãâ "Morning-Drive" Ãâ·Â
		
//		Consumer con=new Consumer();
//		Car mo=new Morning();
//		
//		con.setName("Ã¶¼ö");
//		con.setCar(mo);
//		System.out.println(con.getName());
//		System.out.println(con.personDrive());
		
		ApplicationContext context = new GenericXmlApplicationContext("app2.xml");
		
		
		Consumer con = context.getBean("consumer", Consumer.class);
		con.setName("Ã¶¼ö");

		System.out.println(con.getName());
		System.out.println(con.personDrive());
	}
}
