package aptech.t2008m.authenticationdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/guests")
public class GuestController {
    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Hello Guest";
    }
}
