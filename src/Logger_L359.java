import java.util.HashMap;
import java.util.Map;

public class Logger_L359 {
    Map<String, Integer> messageMap;

    /** Initialize your data structure here. */
    public Logger_L359() {
        messageMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer time = this.messageMap.get(message);
        if (time == null || timestamp - time >= 10) {
            this.messageMap.put(message, timestamp);
            return true;
        }
        return false;
    }
}
