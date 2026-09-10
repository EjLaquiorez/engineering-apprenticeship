public class Lesson34Exercise {
	public static void main(String[] args) {
		String names = "Alice,Bob,Charlie,David";
		

        String[] namesArray = names.split(",");
        System.out.println("Number of names: " + namesArray.length);
        
		for (int i = 0; i < namesArray.length; i++) {
			System.out.println(i+1 + ". " + namesArray[i].toUpperCase());
            
        }


	}
}
