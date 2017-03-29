package section4;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class PartitioningTest {

	List<SoftwareEngineer> engineers;
	
	@Before
	public void setUp() throws Exception {
		engineers=new ArrayList<>();
		engineers.add(new SoftwareEngineer("Saif", 33, true,"Jordan"));
		engineers.add(new SoftwareEngineer("Amin", 31, true,"Egypt"));
		engineers.add(new SoftwareEngineer("Ed", 28, false,"Korea"));
		engineers.add(new SoftwareEngineer("Jonatan", 23, false,"Mexico"));
		engineers.add(new SoftwareEngineer("Ali", 22, true,"Palestine"));
		engineers.add(new SoftwareEngineer("M Allouh", 33, true,"Jordan"));
	}

	@After
	public void tearDown() throws Exception {
		engineers=null;
	}

	@Test
	public void shouldPartionBackEndDevsInOneList() {
		
		List<SoftwareEngineer> seList= engineers.stream()
												.filter(SoftwareEngineer::isBackEnd)
												.collect(toList());
		assertThat(seList.size(), equalTo(4));
		
		Map<Boolean, List<SoftwareEngineer>> engMap= engineers.stream()
				.collect(Collectors.partitioningBy(SoftwareEngineer::isBackEnd));
		
		assertThat(engMap.get(true).size(), equalTo(4));
		assertThat(engMap.get(false).size(), equalTo(2));
	
	}
	
	@Test
	public void shouldPartion20sDevsInOneList() {
		
		Map<Boolean, List<SoftwareEngineer>> 
		engMap=engineers.stream()
						.collect(Collectors.partitioningBy(isAgeMoreThan(29)));
		assertThat(engMap.get(true).size(), equalTo(3));
		
	}
	
	private Predicate<SoftwareEngineer> isAgeMoreThan(Integer age) {
	    return p -> p.getAge() > age;
	}
	
	@Test
	public void ShouldBeBoolean(){
		assertThat(isPrimary(13), equalTo(true));
	}
	
	private boolean isPrimary(int number){
		
		return IntStream.range(2, number).noneMatch(i->number%i==0);
		
	}
	

	
	

}
