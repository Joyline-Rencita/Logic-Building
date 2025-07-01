public class BMICategory {
    public static void main(String[] args) {
        double[] bmiValues = {17.5, 22.3, 27.1, 32.0};

        int underweight = 0, normal = 0, overweight = 0, obese = 0;

        for (double bmi : bmiValues) {
            if (bmi < 18.5) underweight++;
            else if (bmi < 25) normal++;
            else if (bmi < 30) overweight++;
            else obese++;
        }

        System.out.println("Underweight: " + underweight);
        System.out.println("Normal: " + normal);
        System.out.println("Overweight: " + overweight);
        System.out.println("Obese: " + obese);
    }
}
