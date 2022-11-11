package sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("circle1")
public class CircleImpl implements Circle {
    private int x;
    private int y;
    private int redius;
   
    @Autowired  //pointx에다가 shape타입의 객체를 넣겠다
    @Qualifier("ptx")  //자식이 여러개 있을때 적합한 자식을 지정할수있다, 클래스이름이 아닌 참조변수를 써야된다
    private Shape pointx;  // PointX ptx = new PointX();

    
    public CircleImpl() {
    	System.out.println("CircleImpl");
    }
     
    public Shape getPointx() {
		return pointx;
	}
    //지금은 main에서 pointx에서 관리하는 px가 들어와있음
	public void setPointx(Shape pointx) {
		this.pointx = pointx;
	    System.out.println("setPointx(shape pointx)");
	}
	public int getX() {
    	return x;
    }
    public int gety() {
    	return y;
    }
    public String make() {
    	return pointx.make();
    }

	
    }
