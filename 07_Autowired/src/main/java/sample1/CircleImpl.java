package sample1;

public class CircleImpl implements Circle {
    private int x;
    private int y;
    private int redius;
    private Shape pointx; // = new PointX(); 혹은 new PointY();
                          // 현재는 main에서 px가 주입되었기 때문에 안보이지만 =new Poinx();
                          //원래는 shape를 관리해야 하지만 shape은 인터페이스니까 x나 y둘다 객체로 가능
 
    public CircleImpl() {
    	
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
    //지금은 main에서 pointx에서 관리하는 px가 들어와있기 때문에 pointx의 make가 출력이 된다
    public String make() {
    	return pointx.make();
    }

	
    }
