package sample2;

import org.springframework.stereotype.Component;

@Component("ptx") //pointx ��ü ����� ptx�� ���������� �ض� PointX ptx = new PointX()
                  // Ŭ���� �̸��� ���� PointX�� ����
public class PointX implements Shape {

	public PointX() {
		System.out.println("PointX()");
	}
	@Override
	public String make() {	
		return "x�� �����";
	}

	@Override
	public String delete() {
	
		return "x�� �����";
	}

}
