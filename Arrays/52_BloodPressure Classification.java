public class BPClassification {
    public static void main(String[] args) {
        int[][] readings = {
            {110, 75}, {128, 79}, {135, 85}, {145, 95}
        };

        int normal = 0, elevated = 0, stage1 = 0, stage2 = 0;

        for (int[] bp : readings) {
            int sys = bp[0], dia = bp[1];
            if (sys < 120 && dia < 80) normal++;
            else if (sys >= 120 && sys <= 129 && dia < 80) elevated++;
            else if ((sys >= 130 && sys <= 139) || (dia >= 80 && dia <= 89)) stage1++;
            else stage2++;
        }

        System.out.println("Normal: " + normal);
        System.out.println("Elevated: " + elevated);
        System.out.println("Stage 1: " + stage1);
        System.out.println("Stage 2: " + stage2);
    }
}
