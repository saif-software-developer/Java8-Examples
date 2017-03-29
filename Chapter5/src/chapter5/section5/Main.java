package chapter5.section5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;

public class Main {

	public static void main(String[] args) {
		
		Trader raoul=new Trader("Raoul", "Cambridge");
		Trader mario=new Trader("Mario", "Milan");
		Trader alan=new Trader("Alan", "Cambridge");
		Trader brian=new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions= Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
				
		Comparator<Transaction> byTransactionValue = (t1, t2) -> Integer.compare(
	            t1.getValue(), t2.getValue());
		
		//Find all transactions in 2011 and sort them by value (small to high)
		System.out.println("*Find all transactions in 2011 and sort them by value (small to high) \n");
		transactions.stream()
					.filter(t->t.getYear()==2011)
					.sorted(byTransactionValue)
					.forEach(System.out::println);
		
		
		//What are all unique cities where traders work
		System.out.println("\n*What are all unique cities where traders work\n");
		List<Trader> traders= Arrays.asList( 
				raoul,mario,alan,brian);
		
		traders.stream().map(Trader::getCity).distinct()
						.forEach(System.out::println);
		
		//Find all traders by Cambridge and sort them by name
		System.out.println("\n*Find all traders by Cambridge and sort them by name\n");
		traders.parallelStream()
		.filter(t->t.getCity().equals("Cambridge"))	
		.sorted((t1,t2)->t1.getName().compareTo(t2.getName()))
		.forEach(System.out::println);
		
		traders.parallelStream().filter(t->t.getCity().equals("Cambridge"))
		.sorted(Comparator.comparing(Trader::getName))
		.distinct()
		.forEach(System.out::println);
		
		//Return a string of all traders names sorted alphabetically 
		System.out.println("\n* Return a string of all traders names sorted alphabetically \n");
		String result=traders.parallelStream()
				.map(Trader::getName)
				.sorted()
				.collect(joining(" "));
		
		System.out.println(result);
		
		//Are any traders based in Milan ?
		System.out.println("\n* Are any traders based in Milan ? \n");
		boolean anyTraderBasedInMilan=traders.parallelStream().anyMatch(t->t.getCity().equals("Milan"));
		System.out.println(anyTraderBasedInMilan);
		
		List cambridgeTraders=traders.parallelStream()
				.filter(t->t.getCity().equals("Cambridge"))
				.collect(toList());
		
		//Print all transaction's values from the traders live in Cambridge
		System.out.println("\n *Print all transaction's values from the traders live in Cambridge \n");
		transactions.parallelStream()
					.filter(t->t.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getValue).forEach(System.out::println);
		
		//What is the highest value of all transactions ? 
		System.out.println("\n * What is the highest value of all transactions ? \n");
		Optional<Integer>maxTrans=transactions
				.parallelStream()
				.map(Transaction::getValue)
				.reduce(Integer::max);
		System.out.println(maxTrans.get());
		
		//Find the transaction with the smallest value
		System.out.println("\n * Find the transaction with the smallest value ? \n");
		Optional<Integer>minTrans=transactions
				.parallelStream()
				.map(Transaction::getValue)
				.reduce(Integer::min);
		System.out.println(minTrans.get());
		

	}

}
