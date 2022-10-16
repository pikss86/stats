package stats;

import java.util.HashSet;
import java.util.Set;

public class Functions {
    public double avg(DataItem[] data) {
        double avgValue = 0;
        long nullCount = 0;
        for (DataItem item : data) {
            if (item.ups_adv_battery_run_time_remaining == null)
                nullCount++;
            else
                avgValue += item.ups_adv_battery_run_time_remaining;
        }
        avgValue = avgValue / (data.length - nullCount);
        return avgValue;
    }

    public long max(DataItem[] data) {
        long maxValue = data[0].ups_adv_output_voltage;
        for (DataItem item : data) {
            if (item.ups_adv_output_voltage != null)
                if (item.ups_adv_output_voltage > maxValue)
                    maxValue = item.ups_adv_output_voltage;
        }
        return maxValue;
    }

    public Set<String> values(DataItem[] data) {
        Set<String> valuesSet = new HashSet<>();
        for (DataItem item : data) {
            if (item.host != null)
                valuesSet.add(item.host);
        }
        return valuesSet;
    }
}
