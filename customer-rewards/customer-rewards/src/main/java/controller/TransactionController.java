package controller;

import model.Transaction;
import model.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class TransactionController {
    @Autowired
    private TransactionService transactionService;


    @PostMapping("/calculateRewards")
    public Map<Long, Integer> calculateRewards(@RequestBody List<Transaction> alltransaction) {

        return transactionService.calculateRewards(alltransaction);
    }


}
