package com.spectrum.crm.controller;

import com.spectrum.crm.service.UserService;
import com.spectrum.crm.util.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "api/crm/userRegister", method = RequestMethod.POST)
    public CommonResult userRegister(@RequestBody Map map) {
        logger.info("接收数据为" + map);
        return userService.userRegister(map);
    }

    @RequestMapping(value = "api/crm/selectUserInfoByIdNo", method = RequestMethod.GET)
    public CommonResult selectUserInfoByIdNo(String idNo) {

        return userService.selectUserInfoByIdNo(idNo);
    }

    /**
     * 分页查询列表数据，条件查询
     *
     * @param
     * @return
     */
    @RequestMapping(value = "api/crm/list", method = RequestMethod.GET)
    public CommonResult list() {
        return  userService.list();
    }
}
