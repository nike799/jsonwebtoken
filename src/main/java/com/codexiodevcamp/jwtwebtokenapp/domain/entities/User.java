package com.codexiodevcamp.jwtwebtokenapp.domain.entities;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity implements UserDetails {
    private String name;
    private String username;
    private String password;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;
    private Set<Role> authorities;

    public User() {

        this.authorities = new HashSet<>();
    }

    @Column
    public String getName() {
        return name;
    }

    @Override
    @Column(name = "password")
    public String getPassword() {
        return this.password;
    }

    @Override
    @Column(name = "username", unique = true)
    public String getUsername() {
        return this.username;
    }

    @Override
    @Column(name = "is_account_non_expired")
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    @Column(name = "is_account_non_locked")
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    @Column(name = "is_credential_non_expired")
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    @Column(name = "is_enabled")
    public boolean isEnabled() {
        return false;
    }

    @Override
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    public Set<Role> getAuthorities() {
        return this.authorities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
