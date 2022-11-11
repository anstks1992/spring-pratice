package sample3;

import org.springframework.stereotype.Component;

@Component("morning") // Moring moring = new Moring();
public class Morning implements Car{

	public Morning() {
		System.out.println("Morning()");
	}
	@Override
	public String drive() {
		return "Morning-Drive";
	}

}
