package chapter8.observer;

public class MakeCoffee implements Observer{

	@Override
	public void wakeUp() {
		System.out.println("Be nice, Make them a coffee :) ");
	}

}
