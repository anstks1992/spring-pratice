package sample2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
//	    PointX px = new PointX();
//	    PointY py = new PointY();
//	    
//	    CircleImpl circle = new CircleImpl(); //부모타입으로 자식을 관리할때는 부모도 가지고 있어야 한다 
//	                                          //고로 circle circle는 안됨
//	    circle.setPointx(px);
//	    System.out.println(circle.make());
		
		// app.xml에서 써놓은데로 동작하게 하기 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Circle circle = context.getBean("circle1",Circle.class);
        // Circle circle = new CircleImpl();
        System.out.println(circle.make());
	}

}
