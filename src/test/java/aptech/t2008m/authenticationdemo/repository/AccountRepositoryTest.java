package aptech.t2008m.authenticationdemo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
    @Test
    public void testPasswordEncoder(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("helloworld"));
        System.out.println(passwordEncoder.encode("helloworld"));
        System.out.println(passwordEncoder.encode("helloworld"));
        System.out.println(passwordEncoder.matches("helloworld", "$2a$10$F5QGaxTx8xWj4g9SbG7bFOxXumkgxlhOpiNfSE/S1BQwEQgcNkBpa"));
    }
}