package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	private int num;
	
	@NotBlank( message = "�̸��� �ʼ��Դϴ�") //���������� ��ȿ���˻� �޽����� ����
	private String name;
	
	@Range(min =10, max = 100, message = "���̴� 10~100�� ������ �����մϴ�")
	private int age;
	
	//@NotNull(message="���������� 1�� �̻� �����ؾ� �մϴ�.") //o
	//@NotEmpty(message="���������� 1�� �̻� �����ؾ� �մϴ�.")//o
	@NotBlank(message="���������� 1�� �̻� �����ؾ� �մϴ�.")//o
	private String area;
	
	//@NotNull(message="����Ÿ���� 1�� �̻� �����ؾ� �մϴ�.")//o
	//@NotEmpty(message="����Ÿ���� 1�� �̻� �����ؾ� �մϴ�.")//o
	@NotBlank(message="����Ÿ���� 1�� �̻� �����ؾ� �մϴ�.")//o
	private String style;
	

	//@NotNull(message="���ϴ� ���ݴ븦 �����ؾ� �մϴ�.")// x
	//@NotBlank(message="���ϴ� ���ݴ븦 �����ؾ� �մϴ�.")// x
	@NotEmpty(message="���ϴ� ���ݴ븦 �����ؾ� �մϴ�.")//o
	private String price;
		
	public TravelBean() {
		super();
	
	}
	public TravelBean(int num, String name, int age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) { // ����,������,�Ϻ� �ڱⰡ �˾Ƽ� ��ǥ���� 
		this.area = area;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}

