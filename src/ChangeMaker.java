import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.Entry;

public class ChangeMaker {
    private int[] denominations;

    private int[] coinCount;
    private int[] lastCoins;

    public int[] getDenominations() {
        return denominations;
    }

    public void setDenominations(int[] denominations) {
        this.denominations = denominations;
    }

    public Change makeChange(int amount) {
        this.coinCount = new int[amount + 1];
        this.lastCoins = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            this.makeChangeForSubAmount(i);
        }

//        System.out.println(Arrays.toString(coinCount));
//        System.out.println(Arrays.toString(lastCoins));

        return this.toChange();
    }

    private void makeChangeForSubAmount(int subAmount) {
        if (subAmount == 0) {
                return;
        }

        Map<Integer, Integer> countDenominationMap = new HashMap<>();
        for(int denomination: denominations) {
            if (denomination > subAmount) {
                break;
            }

            int coinCount = this.coinCount[subAmount - denomination] + 1;
            countDenominationMap.put(denomination, coinCount);
        }

        Entry<Integer, Integer> minEntry = this.minCountDenomination(countDenominationMap);
        this.coinCount[subAmount] = minEntry.getValue();
        this.lastCoins[subAmount] = minEntry.getKey();
    }

    private Entry<Integer, Integer> minCountDenomination(Map<Integer, Integer> map) {
        Entry<Integer, Integer> min = null;
        for(Entry<Integer, Integer> entry: map.entrySet()) {
            if (min == null || entry.getValue() < min.getValue()) {
                min = entry;
            }
        }

        return min;
    }

    private Change toChange() {
        Change change = new Change();

        for (int i = lastCoins.length - 1; i != 0; i -= lastCoins[i]) {
            change.addCoin(lastCoins[i]);
        }

        return change;
    }
}
