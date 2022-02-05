package stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

public class GroupingTransaction {
	public static List<CurrencyTransaction> CurrencyTransactions = Arrays.asList( new CurrencyTransaction(Currency.EUR, 1500.0),
            new CurrencyTransaction(Currency.USD, 2300.0),
            new CurrencyTransaction(Currency.GBP, 9900.0),
            new CurrencyTransaction(Currency.EUR, 1100.0),
            new CurrencyTransaction(Currency.JPY, 7800.0),
            new CurrencyTransaction(Currency.CHF, 6700.0),
            new CurrencyTransaction(Currency.EUR, 5600.0),
            new CurrencyTransaction(Currency.USD, 4500.0),
            new CurrencyTransaction(Currency.CHF, 3400.0),
            new CurrencyTransaction(Currency.GBP, 3200.0),
            new CurrencyTransaction(Currency.USD, 4600.0),
            new CurrencyTransaction(Currency.JPY, 5700.0),
            new CurrencyTransaction(Currency.EUR, 6800.0) );
	public static List<CurrencyTransaction> getTransaction(){
		return CurrencyTransactions;
	}
	public static void main(String[] args) {
		List<CurrencyTransaction> list=getTransaction();
		
		//Group a list of transactions by currency to obtain the sum of the values of all transactions with that
		//currency (returning a Map<Currency, Integer>)
		Map<Currency, DoubleSummaryStatistics> map=list.stream().collect(Collectors.groupingBy(CurrencyTransaction::getCurrency,Collectors.summarizingDouble(CurrencyTransaction::getValue)));
		Map<Currency,Double> map2= map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, value->value.getValue().getSum()));
		//System.out.println(map2);
		map2.forEach((k,v)-> {System.out.println(k + ":"+ v);});
		
		//Partition a list of transactions into two groups: expensive and not expensive (returning a
		//Map<Boolean, List<Transaction>>)
		Map<Currency,List<CurrencyTransaction>>map3=list.stream().collect(Collectors.groupingBy(CurrencyTransaction::getCurrency));
		System.out.println(map3);
		ExecutorService exec;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
