package builder;

public class BuilderEverydayDemo {

	public static void main(String[] args) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("This is an example");
		builder.append(" of builder pattern");
		builder.append(" i am going to write");
		builder.append(" something over here ");
		builder.append(42);
		
		System.out.println(builder.toString());

	}

}
