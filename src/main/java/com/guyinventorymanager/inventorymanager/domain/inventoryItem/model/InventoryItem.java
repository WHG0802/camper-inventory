package com.guyinventorymanager.inventorymanager.domain.inventoryItem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.guyinventorymanager.inventorymanager.domain.camper.model.Camper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private InventoryType inventoryType;


    @ManyToOne
    @JsonBackReference
    private Camper owner;

    public String toString() {
        return String.format("%d %s %s %s", id, name, description, inventoryType);
    }
}
