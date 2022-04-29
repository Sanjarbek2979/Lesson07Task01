package com.example.task01.entity;

import com.example.task01.entity.enums.Permission;
import com.example.task01.entity.template.AbsEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Sanjarbek Allayev, вс 11:43. 24.04.2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbsEntity implements UserDetails {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Role role;

    private boolean enabled;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Permission> permissions = this.role.getPermissions();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (Permission permission : permissions) {
//            grantedAuthorities.add(new GrantedAuthority() {
//                @Override
//                public String getAuthority() {
//                    return permission.name();
//                }
//            });
//        }

        for (Permission permission : permissions) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.name())
            );
        }

        return grantedAuthorities;
    }

    public User(String fullName, String username, String password, Role role, boolean enabled) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }
}

