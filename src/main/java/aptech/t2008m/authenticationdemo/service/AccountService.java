package aptech.t2008m.authenticationdemo.service;

import aptech.t2008m.authenticationdemo.entity.Account;
import aptech.t2008m.authenticationdemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public boolean register(Account account){
        account.setPasswordHash(passwordEncoder.encode(account.getPasswordHash()));
        account.setRoleId(1);
        account.setStatus(1);
        accountRepository.save(account);
        return true;
    }
}
