package designPattern;

import java.time.LocalDate;

public class FactoryMethod {

	public static class LocalDateFactory {
		
		private static LocalDate unixEpoch = LocalDate.of(1970, 1, 1);
		
		//Singleton
		public static LocalDate unixEpochDay() {
			
			return unixEpoch;
		}
		
		//The name of the function tells users how to create a new instance
		public static LocalDate fromInt(int yyyyMMdd) {
			
			int year = yyyyMMdd / 10000;
			int month = (yyyyMMdd % 10000) / 100;
			int dayOfMonth = yyyyMMdd % 100;
			
			return LocalDate.of(year, month, dayOfMonth);
		}		
		
		public static LocalDate fromString(String yyyyMMdd) {
			if(yyyyMMdd.length() != 8) {
				return null;
			}
			String representation = yyyyMMdd.substring(0, 3) + "-" + yyyyMMdd.substring(4, 5) +
					"-" + yyyyMMdd.substring(6, 7);
			
			return LocalDate.parse(representation);
		}
	}
	
	//Return derived class
	public static class PersonFactory {
		
		public static Person newInstance(String identity) {
			
			if(identity.equals("customer")) {
				return new Customer();
			} else {
				return new Employee();
			}
		}
		
	}
	
	public static abstract class Person {
		
		public abstract String identity();
	}
	
	public static class Customer extends Person{

		@Override
		public String identity() {
			// TODO Auto-generated method stub
			return "customer";
		}
		
	}
	
	public static class Employee extends Person{

		@Override
		public String identity() {
			// TODO Auto-generated method stub
			return "employee";
		}
		
	}
}
