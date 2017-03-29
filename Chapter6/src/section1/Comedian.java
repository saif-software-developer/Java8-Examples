package section1;

public class Comedian {
	
	private String  name;
	private Integer age;
	private Integer salary;
	private String  state;
	
	public Comedian(String name, Integer age, Integer salary, String state) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.state = state;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Comedian [name=" + name + ", age=" + age + ", salary=" + salary
				+ ", state=" + state + "]";
	}
	
	

}
