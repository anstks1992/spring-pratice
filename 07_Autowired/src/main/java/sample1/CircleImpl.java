package sample1;

public class CircleImpl implements Circle {
    private int x;
    private int y;
    private int redius;
    private Shape pointx; // = new PointX(); Ȥ�� new PointY();
                          // ����� main���� px�� ���ԵǾ��� ������ �Ⱥ������� =new Poinx();
                          //������ shape�� �����ؾ� ������ shape�� �������̽��ϱ� x�� y�Ѵ� ��ü�� ����
 
    public CircleImpl() {
    	
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
    //������ main���� pointx���� �����ϴ� px�� �����ֱ� ������ pointx�� make�� ����� �ȴ�
    public String make() {
    	return pointx.make();
    }

	
    }
