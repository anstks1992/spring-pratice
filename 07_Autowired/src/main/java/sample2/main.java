package sample2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
//	    PointX px = new PointX();
//	    PointY py = new PointY();
//	    
//	    CircleImpl circle = new CircleImpl(); //�θ�Ÿ������ �ڽ��� �����Ҷ��� �θ� ������ �־�� �Ѵ� 
//	                                          //��� circle circle�� �ȵ�
//	    circle.setPointx(px);
//	    System.out.println(circle.make());
		
		// app.xml���� ��������� �����ϰ� �ϱ� 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Circle circle = context.getBean("circle1",Circle.class);
        // Circle circle = new CircleImpl();
        System.out.println(circle.make());
	}

}
