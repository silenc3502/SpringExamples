package com.example.demo.security;

import com.example.demo.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUser extends User {
    private Member member;

    public CustomUser(String username, String passwd,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, passwd, authorities);
    }

    public CustomUser(Member member) {
        super(member.getUserId(), member.getUserPw(),
                member.getAuthList().stream()
                        .map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
                        .collect(Collectors.toList()));

        this.member = member;
    }

    public Member getMember() {
        return member;
    }
}
