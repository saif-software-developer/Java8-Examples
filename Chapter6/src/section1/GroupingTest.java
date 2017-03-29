package section1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;


public class GroupingTest {

	List<Comedian> comedians;
	
	@Before
	public void setUp() throws Exception {
		comedians=new ArrayList<Comedian>();
		comedians.add(new Comedian("Aziz Ansari", 33,17000000,"NY" ));
		comedians.add(new Comedian("Jo Koy", 52,1000000,"PA"));
		comedians.add(new Comedian("Saif", 52,2000000,"PA"));
		comedians.add(new Comedian("Gabriel Iglesias", 40,10000000,"CA" ));
		comedians.add(new Comedian("Russell Peters", 46,21000000,"CA"  ));
		
		
	}

	@Test
	public void test() {
		Map<String, List<Comedian>> map=comedians.stream().collect(groupingBy(Comedian::getState));
		
		assertThat(2, equalTo(map.get("CA").size()));
		assertThat(1, equalTo(map.get("NY").size()));
		
		assertThat("Jo Koy", equalTo(map.get("PA").get(0).getName()));
		
	}
	
	@Test
	public void test2() {
		Map<String, Long> map=comedians.stream()
				.collect(groupingBy(Comedian::getState, counting()));
		
		assertThat(2L, equalTo(map.get("CA")));
		assertThat(2L, equalTo(map.get("PA")));
		
	}
	
	@Test
	public void test3() {
		Map<String, Optional<Comedian>> map=comedians.stream()
				.collect(groupingBy(Comedian::getState, 
						Collectors.maxBy(Comparator.comparingInt(Comedian::getSalary))));
		
		assertThat("Russell Peters", equalTo(map.get("CA").get().getName()));
		assertThat("Saif", equalTo(map.get("PA").get().getName()));
		
	}
	
	@Test
	public void test4(){
		 String text= "aa, bb";
		 List<String> groupList= Arrays.asList(text.split(","));
		 assertThat(groupList.size(), equalTo(2));
		 
		 text= "aa";
		 groupList= Arrays.asList(text.split(","));
		 assertThat(groupList.size(), equalTo(1));
		 
		 
		 text= "aa,bb";
		 groupList= Arrays.asList(text.split(","));
		 assertThat(groupList.size(), equalTo(2));
		 
		 
	}
	
	@Test
	public void test5(){
		
		List<String> list1= Arrays.asList(new String[]{"aa","bb","cc"});
		List<String> list2= Arrays.asList(new String[]{"aa","bb","cc","dd"});
		Collection<String> collection= Collections.emptyList();
		collection.addAll(list1);
		collection.addAll(list2);
		
	}
	

}
