package chapter8.template;

public abstract class FlowManager {

	public final void startFlow(){
        phase1();
        phase2();
    }
    public abstract void phase1();
    public abstract void phase2();
}
