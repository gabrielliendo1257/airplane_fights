package com.gcorp.service.app.authorizationservice.security.model;

import com.gcorp.service.app.authorizationservice.util.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSecurity implements UserDetails
{
    private String username;
    private String password;
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<SimpleGrantedAuthority> stream = this.role.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .toList();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>(stream);
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.role.name()));

        return authorities;
    }
}
