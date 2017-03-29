package section1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CollectBySubGroups {

	
	public static void main(String args[]){
		
		List<Comedian> comedians;
		comedians=new ArrayList<Comedian>();
		comedians.add(new Comedian("Aziz Ansari", 33,17000000,"NY" ));
		comedians.add(new Comedian("Jo Koy", 52,1000000,"PA"));
		comedians.add(new Comedian("Gabriel Iglesias", 40,10000000,"CA" ));
		comedians.add(new Comedian("Russell Peters", 46,21000000,"CA"  ));
		
		Map<String, List<Comedian>> map1=comedians.stream().collect(
				Collectors.groupingBy(Comedian::getState)
				);
		
		for(String state:map1.keySet()){
			System.out.println("State: " + state 
					+ ", Comedians : " + map1.get(state));
		}
		
		Map<String, Long> map2=comedians.stream().collect(
				Collectors.groupingBy(Comedian::getState,Collectors.counting())
				);
		System.out.println(" - - - - - - ");
		for(String state:map2.keySet()){
			System.out.println("State: " + state 
					+ ", Count : " + map2.get(state));
		}
		
		Map<String, Optional<Comedian>> map3=comedians.stream()
				.collect(
						Collectors.groupingBy(
								Comedian::getState,
								Collectors.maxBy(Comparator.comparing(Comedian::getSalary))));
		
		System.out.println(" - - - - - - ");
		for(String state:map3.keySet()){
			System.out.println("State: " + state 
					+ ", Count : " + map3.get(state));
		}
	}
}
