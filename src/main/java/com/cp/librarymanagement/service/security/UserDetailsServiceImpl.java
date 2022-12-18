package com.cp.librarymanagement.service.security;

import com.cp.librarymanagement.entity.User;
import com.cp.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repo.findUserByUsername(username);
        if(u == null){
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsImpl(u);
    }
}
