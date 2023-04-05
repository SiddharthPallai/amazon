package com.epicminds.training.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sidharth
 */

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Table(name = "item")
@Document(collection="item")
public class Item {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Integer id;
    private String id;

    @Column(name = "name")
    @NotNull(message = "Name is mandatory")
    private String name;

    @Column(name = "price")
    @NotNull(message = "Price is mandatory")
    private int price;

    @Column(name = "quantity")
    @NotNull(message = "Quantity is mandatory")
    private Integer quantity;

    //@OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Item type is mandatory")
    //private ItemType type;
    private String type;
}
