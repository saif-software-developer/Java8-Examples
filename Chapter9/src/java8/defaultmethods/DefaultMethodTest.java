package java8.defaultmethods;

import static org.junit.Assert.*;
import java8.models.FamilyGuyMember;
import java8.models.Meg;
import java8.models.Peter;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class DefaultMethodTest {

	private static final String DEFAULT_STRING="Lois! Lois! Lois! Lois! Lois! "
			+ "Mom! Mom! Mom! \n "
			+ "Mommy! Mommy! Mommy! \n"
			+ "Momma! Momma! Momma! \n"
			+ "Ma! Ma! Ma! Ma! \n"
			+ "Mom! Mom! Mom! Mom! \n"
			+ "Mommy! Mommy! \n"
			+ "Momma! Momma! Momma! \n";
	private static final String megString="You dont know anything about me";
	private static final String peterString="That's not a van, that's my son.";
	private static final String stewieString="Come, ice cream. Come to my mouth. "
			+ "How dare you disobey me!";
	
	
	
	FamilyGuyMember member= null;
	@Before
	public void setUp() throws Exception {
		 member= new Peter();
	}

	@Test
	public void test() {
		assertThat(DEFAULT_STRING, equalTo(member.saySomething()));
	}
	
	@Test
	public void test2() {
		member=new Meg();
		assertThat(megString, equalTo(member.saySomething()));
	}

}
