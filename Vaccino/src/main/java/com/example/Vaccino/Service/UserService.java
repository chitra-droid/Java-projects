package com.example.Vaccino.Service;

import com.example.Vaccino.Model.User;
import com.example.Vaccino.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private BCryptPasswordEncoder BPE  = new BCryptPasswordEncoder(10);
    @Autowired
    AuthenticationManager authM;

    @Autowired
    JwtService jwtservice;

    @Autowired
    UserRepository Urepo;

    public String verify(User u) {
        Authentication authentication = authM.authenticate
                (new UsernamePasswordAuthenticationToken(u.getUsername(),u.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtservice.generateToken(u.getUsername());
        }
        return "failed to generate token";
    }

    public void register(User u) {
         u.setPassword(BPE.encode(u.getPassword()));
         Urepo.save(u);
    }
}
