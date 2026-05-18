package com.study.profile_stack_api.domain.auth.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private final Long memberId;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Long memberId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    // JWT 필터에서 사용 (인증 후 - 비밀번호 불필요)
    public CustomUserDetails(Long memberId, String username, Collection<? extends GrantedAuthority> authorities) {
        this(memberId, username, "", authorities);
    }

    public Long getMemberId() { return memberId; }

    // UserDetails 구현 메서드들...
    @Override public String getUsername() { return username; }
    @Override public String getPassword() { return password; }
    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}