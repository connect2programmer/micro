package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DishTest {
	
	List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Type.MEAT),
			new Dish("beef", false, 700, Type.MEAT),
			new Dish("chicken", false, 400, Type.MEAT),
			new Dish("french fries", true, 530, Type.OTHER),
			new Dish("rice", true, 350, Type.OTHER),
			new Dish("season fruit", true, 120, Type.OTHER),
			new Dish("pizza", true, 550, Type.OTHER),
			new Dish("prawns", false, 300, Type.FISH),
			new Dish("salmon", false, 450, Type.FISH) );

	public List<Dish> getDishes(){
		return menu;
	}
	public static void main(String[] args) {
		List<Dish> list=new DishTest().getDishes();
		List<Dish> ll=list.stream().filter(dish->dish.getType().equals(Type.MEAT)).limit(2).collect(Collectors.toList());
		System.out.println(ll);
		
		List<Integer> array=Arrays.asList(1,2,3,4,5);
		List<Integer> list2=array.stream().map(num->num*num).collect(Collectors.toList());
		System.out.println(list2);
		System.out.println("Count the Number of dishes using Map and reduce");
		long l=list.stream().map(x->1).reduce(0,(a,b)->a+b);
		System.out.println(l);
		
		System.out.println("Find the Sum of All Calories");
		long sumOfCal=list.stream().map(Dish::getCalories).reduce(0,(a,b)->a+b);
		System.out.println(sumOfCal);
		int sumOfCalories=list.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(sumOfCalories);
		
			
	}

}
