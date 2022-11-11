package sample1;

public class main {

	public static void main(String[] args) {
	    PointX px = new PointX();
	    PointY py = new PointY();
	    
	    CircleImpl circle = new CircleImpl();
	    circle.setPointx(px);
	    System.out.println(circle.make());

	}

}
