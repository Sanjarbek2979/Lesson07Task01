package com.example.task01.entity;

import com.example.task01.entity.enums.Permission;
import com.example.task01.entity.enums.RoleTypes;
import com.example.task01.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sanjarbek Allayev, вс 12:00. 24.04.2022
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role extends AbsEntity {

    @Column(nullable = false,unique = true)
    private String name; // ADMIN,USER, va boshqalar

//    @Enumerated(value = EnumType.STRING)
//    private RoleTypes roleType;
//

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Permission> permissions;


    @Column(columnDefinition = "text")
    private String description;

}
