package com.charter.reward.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Purchase> purchases = new ArrayList<>();

    public Customer addToPurchases(Purchase purchase) {
        this.purchases.add(purchase);
        purchase.setCustomer(this);

        return this;
    }
}
