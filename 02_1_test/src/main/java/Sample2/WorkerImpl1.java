package Sample2;

public class WorkerImpl1 implements Worker1 {

	private String name;
	private int age;
	private String job;
	
	
	
	
	
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





	public String getJob() {
		return job;
	}





	public void setJob(String job) {
		this.job = job;
	}





	@Override
	public void getWorkerInfo1() {
		System.out.println("�̸� : " + getName());
		System.out.println("���� : " + getAge());
		System.out.println("���� : " + getJob());
		
	}

	
}
