package sample2;

import org.springframework.stereotype.Component;

@Component("pty") //PointY pty = new PointY()
public class PointY implements Shape {

	public PointY() {
		System.out.println("PointY()");
	}
	
	@Override
	public String make() {
	
		return "y를 만든다";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "y를 지운다";
	}

}
