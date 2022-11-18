package album.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class AlbumBean {
	private int num;
	
	//@NotEmpty( message = "제목 입력 누락") 공백(스페이스)만 넣어도 실행이된다
	@NotBlank( message = "제목 입력 누락") // 공백(스페이스)만 넣으면 실행이 안된다
	private String title;
	
	@Length(min =3, max = 7, message = "3이상~7이하")
	private String singer;
	
	@Min(value = 1000, message = "가격은 최소 1000원 이상입니다.")
	private String price; //유효성 검사는 int가 되지 않는다 
	
	private String day;
	
	public AlbumBean() {
		super();
	}
	
	public AlbumBean(int num, String title, String singer, String price, String day) {
		super();
		this.num = num;
		this.title = title;
		this.singer = singer;
		this.price = price;
		this.day = day;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
}
