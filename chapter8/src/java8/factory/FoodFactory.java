package java8.factory;

public class FoodFactory {
	public static Food cookFoodForMe(String foodName){
		switch(foodName){
			case "Humus": 
				return new Humus();
			case "Falafel": 
				return new Falafel();
			case "Mansaf": 
				return new Mansaf();
		}
		return null;
	}
}
