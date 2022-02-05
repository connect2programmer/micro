package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee(101, "Surjeet", "Bangalore", "2011", 89000.00, 201, "Developer");//89000
		Employee emp2 = new Employee(102, "Anil", "Mumbai", "2013", 19000.00, 201, "Developer");//19000
		Employee emp3 = new Employee(103, "Tarzan", "Bhubaneswar", "2012", 29000.00, 201, "HR");//29000
		Employee emp4 = new Employee(104, "Aravinda", "Berhamour", "2015", 390000.00, 202, "Developer");
		Employee emp5 = new Employee(105, "Deba", "Delhi", "2016", 59000.00, 202, "Testing");
		Employee emp6 = new Employee(106, "Saubhagya", "Cuttack", "2016", 76000.00, 203, "Developer");
		Employee emp7 = new Employee(107, "Priya", "Newyork", "2017", 84000.00, 204, "Testing");
		Employee emp8 = new Employee(108, "Pinki", "Berhamour", "2011", 66000.00, 203, "Sales");
		Employee emp9 = new Employee(109, "Suresh", "Mumbai", "2009", 71000.00, 203, "Testing");
		Employee emp10 = new Employee(110, "Manoj", "Rourkela", "2020", 43000.00, 202, "Marketing");
		Employee emp11 = new Employee(111, "Kajal", "Bhubaneswar", "2019", 31000.00, 204, "Sales");
		Employee emp12 = new Employee(112, "Piyoush", "Hyderabad", "2019", 22000.00, 204, "Developer");
		Employee emp13 = new Employee(113, "Raja", "Berhampur", "2011", 82000.00, 204, "Sales");
		List<Employee> list = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10, emp11, emp12,
				emp13);
		
		System.out.println("Find Max Salary In Each Department");
		Map<Integer,Optional<Employee>> map=list.stream().collect(Collectors.groupingBy(Employee::getDeptid,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		Map<Integer,Double> map2=map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry->entry.getValue().get().getSalary()));
		System.out.println(map2);
		System.out.println("Find Max and Min Salary in Organization");
		DoubleSummaryStatistics stat=list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Max:"+ stat.getMax());
		System.out.println("Min:"+ stat.getMin());
		System.out.println("Sum:"+ stat.getSum());
		System.out.println("Avg:"+ stat.getAverage());
		System.out.println("Number of Emp:"+ stat.getCount());
		System.out.println("Average Salary in Each Dept:");
	    Map<Integer,DoubleSummaryStatistics> map3=	list.stream().collect(Collectors.groupingBy(Employee::getDeptid,Collectors.summarizingDouble(Employee::getSalary)));
		Map<Integer,Double> map4=map3.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry->entry.getValue().getAverage()));
		System.out.println(map4);
		map4.forEach((k,v)-> System.out.println( k +"=" +v));
		
		System.out.println("Sort Employee Object based on Name");
		List ll=list.stream().sorted(Comparator.comparing(Employee::getFirstname).reversed().thenComparing(Employee::getSalary)).collect(Collectors.toList());
		System.out.println(ll);
		System.out.println("Count the Number Of Employees");
		long countEmp=list.stream().map(x->1).reduce(0,(a,b)->a+b);
		System.out.println("No. Of EMployee: "+countEmp);
		
		Map<Integer,List<Employee>> maptest=list.stream().collect(Collectors.groupingBy(Employee::getDeptid));
		System.out.println("Just Group By DeptId::::::::::::");
		System.out.println(maptest);
		
		
		
		
	}

}
