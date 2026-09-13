public class miniExercise02 {
    public static void main(String[] args) {
        String[] descriptions = new String[4];
        double[] amounts = new double[4];

        descriptions[0] = "Lunch";
        amounts[0] = 150;

        descriptions[1] = "Jeepney";
        amounts[1] = 30;

        descriptions[2] = "Coffee";
        amounts[2] = 80;

        descriptions[3] = "Groceries";
        amounts[3] = 500;

        System.out.println(descriptions[0] + " - " + amounts[0]);
        System.out.println(descriptions[1] + " - " + amounts[1]);
        System.out.println(descriptions[2] + " - " + amounts[2]);
        System.out.println(descriptions[3] + " - " + amounts[3]);

        for (int i = 0; i < descriptions.length; i++) {
            System.out.println(descriptions[i] + " - " + amounts[i]);
        }
    }
}