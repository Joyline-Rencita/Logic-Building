import java.util.*;

public class ElectricityBill {
    public static void main(String[] args) {
        int[] units = {85, 120, 340, 600};

        Map<String, Integer> slabs = new LinkedHashMap<>();
        slabs.put("Low (0-100)", 0);
        slabs.put("Medium (101-300)", 0);
        slabs.put("High (301-500)", 0);
        slabs.put("Very High (501+)", 0);

        for (int u : units) {
            if (u <= 100) slabs.put("Low (0-100)", slabs.get("Low (0-100)") + 1);
            else if (u <= 300) slabs.put("Medium (101-300)", slabs.get("Medium (101-300)") + 1);
            else if (u <= 500) slabs.put("High (301-500)", slabs.get("High (301-500)") + 1);
            else slabs.put("Very High (501+)", slabs.get("Very High (501+)") + 1);
        }

        slabs.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
