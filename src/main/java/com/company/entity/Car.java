package com.company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Table(name = "cars")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "plate",unique = true)
    private String plate;
    @Column(name = "dailyPrice")
    private double dailyPrice;
    @Column(name = "modelYear")
    private int modelYear;
    @Column(name = "state")//1available  2 rented 3 maintenance
    private Integer state;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    @ColumnDefault(value = "1")
    private Integer active;

}
