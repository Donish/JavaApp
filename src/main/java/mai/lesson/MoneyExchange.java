package mai.lesson;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoneyExchange {

    public String exchange(Integer sum, String coinDenomination) throws Exception {

        if(coinDenomination.isEmpty())
        {
            throw new Exception("empty string.");
        }
        List<Integer> coinDenominations = new java.util.ArrayList<>(Stream.of(coinDenomination.split(", "))
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .toList());

        String result = "";
        int count = 0;
        while (sum >= coinDenominations.get(0)) {
            if(coinDenominations.get(0) == 0 || coinDenominations.get(0) < 0) {
                break;
            }
            sum -= coinDenominations.get(0);
            count++;
        }
        if (count != 0) {
            result += coinDenominations.get(0).toString() + "[" + count + "]";
        }

        if (sum == 0) {
            return result;
        } else {

            coinDenominations.remove(0);
            coinDenomination = coinDenominations.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            result += ", " + exchange(sum, coinDenomination);
        }

        return result;
    }

}
