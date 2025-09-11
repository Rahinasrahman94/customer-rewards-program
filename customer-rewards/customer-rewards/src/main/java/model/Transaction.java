package model;

import java.time.LocalDate;


public class Transaction {
    private Long Id;
    private Long customer_id;
    private Double amount;

    public Transaction(Long id, Long customer_id, Double amount, LocalDate localDate) {
        Id = id;
        this.customer_id = customer_id;
        this.amount = amount;
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    private LocalDate localDate;


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


}
