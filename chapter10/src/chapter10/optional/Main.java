package chapter10.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static List<State> states;
	static State texas;

	public static void main(String[] args) {
		setup();
		
		if(states!=null){
			for(State state: states){
				//if(state!=null){
					for(Gang gang:state.getGangs()){
						if(gang!=null){
							System.out.println(gang.getName());
						}
					}
				//}
			}
		}
		
	}

	private static void setup() {
		// Define Gang members
		GangMember bonnie = new GangMember()
		.withName("Bonnie")
		.withAge(23);

		GangMember clyde = new GangMember()
		.withName("Clyde")
		.withAge(23);

		GangMember doc = new GangMember()
		.withName("Doc")
		.withAge(23);

		GangMember willis = new GangMember()
		.withName("Willis")
		.withAge(23);

		GangMember jess = new GangMember()
		.withName("Jess")
		.withAge(23);

		GangMember joe = new GangMember()
		.withName("Joe")
		.withAge(23);

		// Define Gangs
		Gang bonnieAndClyde = new Gang().withGangMembers(
				Arrays.asList(bonnie, clyde))
				.withName("Bonnie & Clyde");

		Gang newtonGang = new Gang().withGangMembers(
				Arrays.asList(doc, willis, jess, joe))
				.withName("The Newton Gang");

		// Define state
		texas = new State()
				.withGangs(Arrays.asList(bonnieAndClyde, newtonGang))
				.withName("Texas");

		states = new ArrayList<State>();
		states.add(texas);
		states.add(null);
		states.add(new State().withName("Iowa"));
	}

}
