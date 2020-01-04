package com.spectrum.crm.controller;

import com.spectrum.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@FeignClient
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "api/crm/userRegister", method = RequestMethod.POST)
    public Map userRegister(Map map) {


        Map resultMap = new HashMap();
        return resultMap;
    }
}
