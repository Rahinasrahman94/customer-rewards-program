package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
    public static List<Transaction> calculateRewards(Iterable<Transaction> allTransactions) {
        Map<Long, Double> rewardsVal = new HashMap<>();
        for (Transaction trans : allTransactions) {
            Long id = trans.getCustomer_id();
            int points = 0;
            if (!rewardsVal.containsKey(id)) {
                rewardsVal.put(trans.getCustomer_id(), calculatePoints(trans.getAmount()));
            }
            rewardsVal.put(trans.getCustomer_id(), trans.getAmount() + (calculatePoints(trans.getAmount())))
        }
return rewardsVal;
    }
    public int calculatePoints(Double amount)
    {

    }
}
