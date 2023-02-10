package com.logwintech.Authentication.config;

import com.logwintech.Authentication.entity.User;
import com.logwintech.Authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProjectAuthenticationProvider implements AuthenticationProvider {

//    Set<String> whitelist = new HashSet<>();

    @Autowired
    private UserRepository uRepo;

//    public ProjectAuthenticationProvider(){
//        whitelist.add("0:0:0:0:0:0:0:1");
//    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();

        String password = authentication.getCredentials().toString();

        User user = uRepo.findByEmail(username);

//        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
//
//        String userIp = details.getRemoteAddress();
//
//        System.out.println(userIp);
//        try {
//            System.out.println(InetAddress.getLocalHost().getHostAddress());
//        } catch (UnknownHostException e) {
//            throw new RuntimeException(e);
//        }


//        if (!whitelist.contains(userIp)) throw new BadCredentialsException("Invalid Ip Address");

        System.out.println(user);

        if (user != null){
            if (user.getPassword().equals(password)){
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("USER"));

                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            }
            else throw new BadCredentialsException("Invalid Password");
        }
        else throw  new BadCredentialsException("No user found");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
