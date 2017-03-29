package chapter8.observer;

public class MakeNoise implements Observer{

	@Override
	public void wakeUp() {
		System.out.println("Mewo Mewo Mewo !!! ");		
	}

}
