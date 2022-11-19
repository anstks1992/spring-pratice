package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	private int num;
	
	@NotBlank( message = "이름은 필수입니다") //공백넣을경우 유효성검사 메시지가 나옴
	private String name;
	
	@Range(min =10, max = 100, message = "나이는 10~100살 까지만 가능합니다")
	private int age;
	
	//@NotNull(message="관심지역은 1개 이상 선택해야 합니다.") //o
	//@NotEmpty(message="관심지역은 1개 이상 선택해야 합니다.")//o
	@NotBlank(message="관심지역은 1개 이상 선택해야 합니다.")//o
	private String area;
	
	//@NotNull(message="여행타입은 1개 이상 선택해야 합니다.")//o
	//@NotEmpty(message="여행타입은 1개 이상 선택해야 합니다.")//o
	@NotBlank(message="여행타입은 1개 이상 선택해야 합니다.")//o
	private String style;
	

	//@NotNull(message="원하는 가격대를 선택해야 합니다.")// x
	//@NotBlank(message="원하는 가격대를 선택해야 합니다.")// x
	@NotEmpty(message="원하는 가격대를 선택해야 합니다.")//o
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
	public void setArea(String area) { // 유럽,동남아,일본 자기가 알아서 쉼표찍음 
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

