package com.book;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Reader implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;
    private String fullname;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // UserDetails 메서드

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //READER권한 부여
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    } //계정이 만료되지 않았다는 것을 반환
    @Override
    public boolean isAccountNonLocked() {
        return true;
    } //계정이 잠겨있지 않다는 것을 반환

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    } //자격이 유효하다는 것을 반환

    @Override
    public boolean isEnabled() {
        return true;
    } //계정이 활성화 되어 있다는 것을 반환

}
