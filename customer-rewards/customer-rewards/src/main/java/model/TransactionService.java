package model;

import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
@Service
public class TransactionService {
    public Map<Long, Map<String, Integer>> calculateRewards(Iterable<Transaction> allTransactions) {
        Map<Long,Map<String, Integer>> totalRewards = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        for (Transaction trans : allTransactions) {
          Long cust_id =trans.getCustomer_id() ;
          Double amount = trans.getAmount();
          String month = String.valueOf(trans.getLocalDate());
          Map<String,Integer> rewardsVal = new HashMap<>();
            int rewardPoints  = calculateRewardPoints(trans.getAmount());
            if (totalRewards.containsKey(cust_id)) {
                rewardsVal= totalRewards.get(cust_id);
            }
         else {
    rewardsVal = new HashMap<>();
    totalRewards.put(cust_id, rewardsVal);
            }
            if (rewardsVal.containsKey(month)) {
                int current = rewardsVal.get(month);
                rewardsVal.put(month, current + rewardPoints);
            } else {
                rewardsVal.put(month, rewardPoints);
            }
            if (rewardsVal.containsKey("total")) {
                int currentTotal = rewardsVal.get("total");
                rewardsVal.put("total", currentTotal + rewardPoints);
            } else {
                rewardsVal.put("total", rewardPoints);
            }
        }

        return totalRewards;
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
