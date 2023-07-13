package com.company.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@Table(name = "brands")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")

    private String description;
    @OneToMany(mappedBy = "brand")
    private List<Model>  models;
    @ColumnDefault(value = "1")
    private Integer active;



}
