package chapter8.observer;

public class AdjustTemperature implements Observer{

	@Override
	public void wakeUp() {
		System.out.println("If you can spare a bit of time, "
				+ "you could rely on the house waking this person up for you. "
				+ "Adjust the temperature so their room gets noticeably hotter or colder. "
				+ "They may become slightly uncomfortable, which will cause them to awaken. ");	
	}

}
