package java8.models;

public interface FamilyGuyMember {
	
	public void move();
	
	default public String saySomething(){
		return "Lois! Lois! Lois! Lois! Lois! "
				+ "Mom! Mom! Mom! \n "
				+ "Mommy! Mommy! Mommy! \n"
				+ "Momma! Momma! Momma! \n"
				+ "Ma! Ma! Ma! Ma! \n"
				+ "Mom! Mom! Mom! Mom! \n"
				+ "Mommy! Mommy! \n"
				+ "Momma! Momma! Momma! \n";
	}
}
