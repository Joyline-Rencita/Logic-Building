import java.util.*;

public class SalaryBucket {
    public static void main(String[] args) {
        int[] salaries = {12000, 34000, 45000, 67000, 120000, 15000};

        Map<String, Integer> salaryGroup = new LinkedHashMap<>();
        salaryGroup.put("Low Income", 0);
        salaryGroup.put("Medium Income", 0);
        salaryGroup.put("High Income", 0);
        salaryGroup.put("Very High Income", 0);

        for (int salary : salaries) {
            if (salary < 20000)
                salaryGroup.put("Low Income", salaryGroup.get("Low Income") + 1);
            else if (salary < 50000)
                salaryGroup.put("Medium Income", salaryGroup.get("Medium Income") + 1);
            else if (salary < 100000)
                salaryGroup.put("High Income", salaryGroup.get("High Income") + 1);
            else
                salaryGroup.put("Very High Income", salaryGroup.get("Very High Income") + 1);
        }

        for (Map.Entry<String, Integer> entry : salaryGroup.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
