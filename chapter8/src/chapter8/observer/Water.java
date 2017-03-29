package chapter8.observer;

public class Water implements Observer{

	@Override
	public void wakeUp() {
		System.out.println("Throw a sprinkle of cold water on the person. "
				+ "If all fails, just use the tried-and-true method of cold water. "
				+ "Grab a handful from the nearest bathroom and before it all leaks out through your fingers,"
				+ "splash it on them. They won't be happy, but they'll probably wake up. ");
	}

}
