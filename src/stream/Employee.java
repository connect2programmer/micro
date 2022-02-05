package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

	private int empid;
	private String firstname;
	private String city;
	private String yoj;
	private double salary;
	private int deptid;
	private String deptname;
}
