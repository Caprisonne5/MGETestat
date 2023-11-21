package Services;

import java.util.Random;

public class RandomId {
    public static int generateId() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE);
    }
}
