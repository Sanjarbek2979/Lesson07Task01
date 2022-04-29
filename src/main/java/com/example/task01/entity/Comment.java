package com.example.task01.entity;

import com.example.task01.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author Sanjarbek Allayev, вс 12:30. 24.04.2022
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment extends AbsEntity {

    @Column(nullable = false,columnDefinition = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

}
