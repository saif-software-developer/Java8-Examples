package chapter5.section1;

public class Car {

	private String make;
	private String model;
	private Integer year;
	private Integer price;
	
	public Car(String make, String model, Integer year) {
		this.make=make;
		this.model=model;
		this.year=year;
	}
	
	public Car(String make, String model, Integer year, Integer price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
