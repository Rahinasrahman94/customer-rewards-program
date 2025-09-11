package model;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class TransactionService {
    public Map<Long, Integer> calculateRewards(Iterable<Transaction> allTransactions) {
        Map<Long, Integer> rewardsVal = new HashMap<>();
        for (Transaction trans : allTransactions) {
            int rewardPoints  = calculateRewardPoints(trans.getAmount());
            if (!rewardsVal.containsKey(trans.getCustomer_id())) {
                rewardsVal.put(trans.getCustomer_id(),rewardPoints);
            }
            rewardsVal.put(trans.getCustomer_id(),rewardsVal.get(trans.getCustomer_id())+rewardPoints);
        }
return rewardsVal;
    }
    public int calculateRewardPoints(Double amount)
    {
        int rewardPoints = 0;
        if (amount > 100) {
            rewardPoints += 2 * (int)(amount - 100);
            rewardPoints += 50;
        } else if (amount > 50) {
            rewardPoints += (int)(amount - 50);
        }
        return rewardPoints;
    }

    }
