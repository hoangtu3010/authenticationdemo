package aptech.t2008m.authenticationdemo.service;

import aptech.t2008m.authenticationdemo.entity.Account;
import aptech.t2008m.authenticationdemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Finding username:" + username);
        Optional<Account> optionalAccount = accountRepository.findAccountByUsername(username);
        if (!optionalAccount.isPresent()){
            throw new UsernameNotFoundException("Invalid information.");
        }
        Account account = optionalAccount.get();
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (account.getRoleId() == 1){
            authorities.add(new SimpleGrantedAuthority("user"));
        }else if(account.getRoleId() == 2){
            authorities.add(new SimpleGrantedAuthority("admin"));
        }
        UserDetails userDetails = new User(
                account.getUsername(), account.getPasswordHash(), authorities);
        System.out.println("Return userdetail.");
        return userDetails;
    }
}
