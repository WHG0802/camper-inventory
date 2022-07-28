package com.guyinventorymanager.inventorymanager.domain.camper.model;


import com.guyinventorymanager.inventorymanager.domain.inventoryItem.model.InventoryItem;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Camper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private CamperType camperType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<InventoryItem> inventory;

    public String toString() {
        return String.format("%d %s %s %s %s", id, firstName, lastName, email, camperType);
    }
}
