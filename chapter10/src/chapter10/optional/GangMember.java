package chapter10.optional;

public class GangMember {

	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GangMember withName(String name) {
		this.name = name;
		return this;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public GangMember withAge(Integer age) {
		this.age = age;
		return this;
	}
	
}
