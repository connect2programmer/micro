package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransactionStream {
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario","Milan");
	Trader alan = new Trader("Alan","Cambridge");
	Trader brian = new Trader("Brian","Cambridge");
	List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
			);
	public List<Transaction> getTransaction(){
		return transactions;
	}
	public static void main(String[] args) {
		TransactionStream obj=new TransactionStream();
		List<Transaction> list=obj.getTransaction();

		
		System.out.println("Find all Transaction in 2011 and sort by value");
		
		List<Transaction> tra=list.stream().filter(trans->trans.getYear()==2011).sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList());
		System.out.println(tra);
		
		System.out.println("What are the Unique Cities where the traders work.");
		List<String> uniqueCity=list.stream().map(trans->trans.getTrader().getCity()).distinct().collect(Collectors.toList());
		System.out.println(uniqueCity);
		System.out.println("Find all Traders from Cambridge and sort them by name");
		
		List<Trader> traders=list.stream().map(trans->trans.getTrader()).filter(trader->trader.getCity().equalsIgnoreCase("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		System.out.println(traders);
		System.out.println("Return a String of all traders name sorted alphabetically");
		String tradersName=list.stream().map(trans->trans.getTrader().getName()).distinct().sorted(String::compareTo).collect(Collectors.joining(","));
		System.out.println(tradersName);
		System.out.println("Are any Trader based on Milan");
		boolean isMilan=list.stream().map(trans->trans.getTrader().getCity()).anyMatch(name->name.equals("Milan"));
		System.out.println("Matches: "+ isMilan);
		System.out.println("Print all Transaction values from the Traders living in Cambridge");
		List<Integer> transValue=list.stream().filter(trans->trans.getTrader().getCity().equals("Cambridge")).map(t->t.getValue()).collect(Collectors.toList());
		System.out.println(transValue);
		System.out.println("Whats is the Heighest Value of all the Transaction");
		//List<Transaction> maxTranx=
		Transaction maxVal=list.stream().max(Comparator.comparingInt(Transaction::getValue)).get();
		System.out.println("Max1:"+maxVal);
		

		Integer val=list.stream().max(Comparator.comparing(Transaction::getValue)).get().getValue();
		System.out.println("Max2:"+val);
		
		Map<String,Trader> mm=traders.stream().distinct().collect(Collectors.toMap(key->key.getName(), Function.identity()));
		System.out.println(mm);
		
		List<Integer> ll3=Arrays.asList(4,1,2,5,6,8,9);
		int vv =ll3.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();
		System.out.println(vv);
		
	}

}
