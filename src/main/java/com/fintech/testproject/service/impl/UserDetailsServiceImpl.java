package com.fintech.testproject.service.impl;

import com.fintech.testproject.model.enity.UserAccount;
import com.fintech.testproject.repository.UserAccountRepository;
import com.fintech.testproject.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserDetailsServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findUserAccountByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                String.format("User with the username %s not found!", username))
                );
        Set<GrantedAuthority> authorities = this.collectUserAccountRoles(userAccount);

        return new UserPrincipal(userAccount.getId(), userAccount.getUsername(), userAccount.getPassword(),
                userAccount.isEnabled(), authorities);
    }

    private Set<GrantedAuthority> collectUserAccountRoles(UserAccount userAccount) {
        return userAccount
                .getRoles()
                .stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName().name())
                ).collect(Collectors.toSet());
    }

}