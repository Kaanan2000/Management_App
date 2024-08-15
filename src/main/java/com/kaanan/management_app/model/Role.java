package com.kaanan.management_app.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.kaanan.management_app.model.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(
            Set.of(
                USER_READ
            )
    ),
    MANAGER(
            Set.of(
                USER_READ,
                MANAGER_READ,
                MANAGER_CREATE
            )
    ),
    ADMIN(
            Set.of(
                    USER_READ,
                    MANAGER_READ,
                    MANAGER_CREATE,
                    ADMIN_READ,
                    ADMIN_CREATE,
                    ADMIN_UPDATE,
                    ADMIN_DELETE
            )
    );

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = new ArrayList<>(getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
