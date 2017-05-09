package com.bnisler.service.security;

import com.bnisler.dao.AssistUserDao;
import com.bnisler.entity.AssistUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "assistUserDetailsService")
public class AssistUserDetailsService implements UserDetailsService {

    @Autowired
    private AssistUserDao assistUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AssistUser user = assistUserDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AssistUserPrinciple(user);
    }
}
