package com.example.springshiyan5.service.impl;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class MyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户的身份信息和认证信息
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println("这里进行了验证");
        // 进行身份验证
        if (username.equals("admin") && password.equals("123456")) {
            // 验证成功，返回一个 UsernamePasswordAuthenticationToken 对象
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            Authentication result = new UsernamePasswordAuthenticationToken(username, password, authorities);
            return result;
        } else {
            // 验证失败，抛出 AuthenticationException 异常
            throw new BadCredentialsException("用户名或密码错误");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 只支持 UsernamePasswordAuthenticationToken 类型的 Authentication 对象
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
