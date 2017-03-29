package chapter8.strategy;

public class Translator {

	private Hello hello;

	public Translator(Hello hello) {
		super();
		this.hello = hello;
	}

	@Override
	public String toString() {
		return hello.hello();
	}
	
}
