package sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("circle1")
public class CircleImpl implements Circle {
    private int x;
    private int y;
    private int redius;
   
    @Autowired  //pointx���ٰ� shapeŸ���� ��ü�� �ְڴ�
    @Qualifier("ptx")  //�ڽ��� ������ ������ ������ �ڽ��� �����Ҽ��ִ�, Ŭ�����̸��� �ƴ� ���������� ��ߵȴ�
    private Shape pointx;  // PointX ptx = new PointX();

    
    public CircleImpl() {
    	System.out.println("CircleImpl");
    }
     
    public Shape getPointx() {
		return pointx;
	}
    //������ main���� pointx���� �����ϴ� px�� ��������
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
