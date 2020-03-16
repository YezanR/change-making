import java.util.HashMap;
import java.util.Map;

public class Change {
    private int coinsCount;
    private Map<Integer, Integer> coins = new HashMap<>();

    public void addCoin(int coin) {
        Integer coinCount = coins.get(coin);
        if (coinCount == null) {
            coinCount = 0;
        }

        coins.put(coin, coinCount + 1);
        coinsCount++;
    }

    public int getCoinsCount() {
        return coinsCount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<Integer, Integer> entry: coins.entrySet()) {
            stringBuilder.append(entry.getValue() + "x(" + entry.getKey() + ") ");
        }

        return stringBuilder.toString();
    }
}
