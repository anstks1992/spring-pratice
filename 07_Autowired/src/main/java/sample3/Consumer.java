package sample3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("consumer") //  Consumer consumer = new Consumer();
public class Consumer implements Person{

	private String name;

	@Autowired 
	@Qualifier("morning") // @Component("morning")
	private Car car; // new Morning()
	
	public Consumer() {
		System.out.println("Consumer()");
	}
	
	public Car getCar() {
		return car;
	}
	
	// Car car = new Morning()
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String personDrive() {
		return car.drive();
	}
}
