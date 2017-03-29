package chapter8.template;

import java.util.function.Consumer;

public abstract class FlowManagerJava8<T> {

	public final void startFlow(T t,
			Consumer<T> phase1, 
			Consumer<T> phase2){
        phase1.accept(t);
        phase2.accept(t);
    }
}
