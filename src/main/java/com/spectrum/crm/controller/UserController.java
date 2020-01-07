package com.spectrum.crm.controller;

import com.spectrum.crm.data.User;
import com.spectrum.crm.service.UserService;
import com.spectrum.crm.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "api/crm/userRegister", method = RequestMethod.POST)
    public CommonResult userRegister(@RequestBody Map map) {

        return userService.userRegister(map);
    }

    @RequestMapping(value = "api/crm/selectUserInfoByIdNo", method = RequestMethod.GET)
    public CommonResult selectUserInfoByIdNo(String idNo) {

        return userService.selectUserInfoByIdNo(idNo);
    }
}
