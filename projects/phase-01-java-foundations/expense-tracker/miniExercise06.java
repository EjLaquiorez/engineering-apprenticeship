public class miniExercise06 {

    public static void main(String[] args) {
        String[] descriptions = {"bus", "lunch", "coffee"};
        double[] amounts = {200, 120, 50};
        int expenseCount = 3;
        String search = "co";
        boolean foundSearch = false;

        for (int i = 0; i < expenseCount; i++) {
            if(descriptions[i].contains(search)){
                System.out.println(descriptions[i] + " - " + amounts[i]);
                System.out.println("Found!");
                foundSearch = true;
            }
        }

        if (!foundSearch) {
            System.out.println("No matching expenses found.");
        }
    }
}
