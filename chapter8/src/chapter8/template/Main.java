package chapter8.template;

import java.util.function.Consumer;

public class Main {

	public static void main(String args[]){
		
		
		new FlowManager2<String>().startFlow("Helo World",
				(String message)->System.out.println("Phase 1 : "+ message),
				(String message)->System.out.println("Phase 2 : "+ message));
		
		
		Consumer<String> phase1 = (String message)-> System.out.println("Phase 1 : "+ message);
		Consumer<String> phase2 = (String message)-> System.out.println("Phase 2 : "+ message);
		
		new FlowManager2<String>().startFlow("Helo World",
				phase1,
				phase2);
		
		
		Consumer<Task> consumer1 = (Task task)-> { task.setProgress(20);
		 System.out.println("Phase 1 : "+ task.getId() +" "+  task.getProgress());
		};
		Consumer<Task> consumer2 = (Task task)-> { task.setProgress(50);
		 System.out.println("Phase 2 : "+ task.getId() + " "+ task.getProgress());
		};
		
		new FlowManager2<Task>().startFlow(new Task("id1",0), consumer1, consumer2);
		
	}
	
	
}
