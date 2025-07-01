import java.util.*;

public class LoanBucket {
    public static void main(String[] args) {
        int[] amounts = {15000, 48000, 60000, 120000};

        Map<String, Integer> risk = new LinkedHashMap<>();
        risk.put("Small Loan (<20k)", 0);
        risk.put("Moderate Loan (20k–49k)", 0);
        risk.put("High Loan (50k–99k)", 0);
        risk.put("Very High Loan (100k+)", 0);

        for (int amt : amounts) {
            if (amt < 20000) risk.put("Small Loan (<20k)", risk.get("Small Loan (<20k)") + 1);
            else if (amt < 50000) risk.put("Moderate Loan (20k–49k)", risk.get("Moderate Loan (20k–49k)") + 1);
            else if (amt < 100000) risk.put("High Loan (50k–99k)", risk.get("High Loan (50k–99k)") + 1);
            else risk.put("Very High Loan (100k+)", risk.get("Very High Loan (100k+)") + 1);
        }

        risk.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
