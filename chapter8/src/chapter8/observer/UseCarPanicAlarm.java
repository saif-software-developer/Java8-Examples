package chapter8.observer;

public class UseCarPanicAlarm implements Observer {

	@Override
	public void wakeUp() {
		System.out.println("You can try pressing the panic alarm on you car to wake the person up – "
				+ "when the person does wakes up, "
				+ "stop it and they'll think someone else's car alarm went off outside.");
	}

}
