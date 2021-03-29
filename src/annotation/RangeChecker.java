package annotation;

import java.lang.reflect.Field;

public class RangeChecker {
	void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
		
		for(Field field : person.getClass().getFields()) {
			Range range = field.getAnnotation(Range.class);
			if(range != null) {
				Object value = field.get(person);
				if(value instanceof String) {
					String s = (String) value;
					if(s.length() > range.max() || s.length() < range.min()) {
						throw new IllegalArgumentException("Invalid field: " + field.getName());
					}
				}
			}
			
		}
	}

}
