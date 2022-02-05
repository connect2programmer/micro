package arraystream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamArrayTest {

	public static int add(int n) {
		return Stream.iterate(1, i->i+1).limit(n).parallel().reduce(0, (a,b)->a+b );
	}
	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,9,8,12);
		int value=list.stream().reduce(1, (a,b)->a*b);
		System.out.println(value);
		int max=list.stream().reduce(Integer::max).get();
		System.out.println("Max: "+max);
		
		System.out.println("Find Eve Number from 1 to 100");
		IntStream.rangeClosed(1, 100).filter(num->num%2==0).count();
		System.out.println("Generate 5 Random Number");
		Stream.generate(Math::random).limit(5).forEach(System.out::println);
		
		//SPlit the stream into two part >5 and less thn 10
		Map<Boolean,Long> part=list.stream().collect(Collectors.groupingBy(num->num>5,Collectors.counting()));
		System.out.println(part);
		
        Stream<String> s = Stream.of("Ace", "heart", "Club", "diamond");
        Map<Boolean,List<String>> mapup=s.collect(Collectors.partitioningBy(x->Character.isUpperCase(x.charAt(0))));
		System.out.println(mapup);
		System.out.println(add(10));
		
		
		
	}

}
