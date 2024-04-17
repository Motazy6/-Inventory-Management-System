
package com.example.pro1.Entity;
import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "produtcs")
public class Produtcs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mid")
    private int id;


    @Column(name="name")
    private String name;


    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;


    @Column(name="quantity")
    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mid", referencedColumnName = "mid", insertable = false, updatable = false)
    private Orders orders;

}
