package sample2;

import org.springframework.stereotype.Component;

@Component("ptx") //pointx 객체 만들고 ptx를 참조변수로 해라 PointX ptx = new PointX()
                  // 클래스 이름과 같은 PointX도 가능
public class PointX implements Shape {

	public PointX() {
		System.out.println("PointX()");
	}
	@Override
	public String make() {	
		return "x를 만든다";
	}

	@Override
	public String delete() {
	
		return "x를 지운다";
	}

}
