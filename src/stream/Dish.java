package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
}
