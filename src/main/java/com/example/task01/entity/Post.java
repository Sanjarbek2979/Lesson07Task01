package com.example.task01.entity;

import com.example.task01.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Sanjarbek Allayev, вс 12:26. 24.04.2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends AbsEntity {

    @Column(nullable = false,columnDefinition = "text")
    private String title;

    @Column(nullable = false,columnDefinition = "text")
    private String text;


    @Column(nullable = false,columnDefinition = "text")
    private String url;


}
