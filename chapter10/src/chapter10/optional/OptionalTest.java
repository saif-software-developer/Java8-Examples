package chapter10.optional;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
 
public class OptionalTest {

	List<State> states;
	State texas;
	
	@Before
	public void setUp() throws Exception {
		
		//Define Gang members 
		GangMember bonnie=new GangMember()
		.withName("Bonnie")
		.withAge(23);
		
		GangMember clyde=new GangMember()
		.withName("Clyde")
		.withAge(23);
		
		GangMember doc=new GangMember()
		.withName("Doc")
		.withAge(23);
		
		GangMember willis=new GangMember()
		.withName("Willis")
		.withAge(23);
		
		GangMember jess=new GangMember()
		.withName("Jess")
		.withAge(23);
		
		GangMember joe=new GangMember()
		.withName("Joe")
		.withAge(23);
		
		//Define Gangs 
		Gang bonnieAndClyde=new Gang()
		.withGangMembers(Arrays.asList(bonnie,clyde))
		.withName("Bonnie & Clyde");
		
		Gang newtonGang=new Gang()
		.withGangMembers(Arrays.asList(doc,willis,jess,joe))
		.withName("The Newton Gang");
		
		//Define state
		texas =new State()
		.withGangs(Arrays.asList(bonnieAndClyde, newtonGang))
		.withName("Texas");
		
		states=new ArrayList<State>();
		states.add(texas);
		
	}

	@Test
	public void test() {
		Optional container = Optional.of(states);
		assertThat(states,equalTo(container.get()));
	}
	
	@Test
	public void test2() {
		Optional<State> container = Optional.empty();
		Optional<State> actualState= states
				.stream()
				.filter(state->state.getName().equals("Iowa")).findAny();
				
		assertThat(actualState,equalTo(container));
	}
	
	@Test
	public void test3() {
		Optional<State> container = Optional.of(texas);
		Optional<State> actualState= states
				.stream()
				.filter(state->state.getName().equals("Texas")).findAny();
				
		assertThat(actualState,equalTo(container));
	}

}
