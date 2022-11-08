package Sample2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain1 {

	public static void main(String[] args) {
		
	AbstractApplicationContext context = new GenericXmlApplicationContext("Aop2.xml");	
    Student1 stu = (Student1)context.getBean("student1");
    stu.getStudentInfo1();
    
    System.out.println("=====================================");
    
    Worker1 wor = (Worker1)context.getBean("worker1");
    wor.getWorkerInfo1();
	}

}
