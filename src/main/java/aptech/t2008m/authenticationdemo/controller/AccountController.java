package aptech.t2008m.authenticationdemo.controller;

import aptech.t2008m.authenticationdemo.entity.Account;
import aptech.t2008m.authenticationdemo.repository.AccountRepository;
import aptech.t2008m.authenticationdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Hello User";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Account> register(@RequestBody Account account){
        accountService.register(account);
        return null;
    }
}