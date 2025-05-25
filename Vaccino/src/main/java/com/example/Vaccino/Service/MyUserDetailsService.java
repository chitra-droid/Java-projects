package com.example.Vaccino.Service;


import com.example.Vaccino.Config.UserPrincipal;
import com.example.Vaccino.Model.User;
import com.example.Vaccino.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository UR;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = UR.findByUsername(username);

        if(u==null){
            throw new UsernameNotFoundException("User not Found!");
        }
        return new UserPrincipal(u);
    }
}
