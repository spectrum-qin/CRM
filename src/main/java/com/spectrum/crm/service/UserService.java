package com.spectrum.crm.service;

import com.spectrum.crm.util.CommonResult;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {

    CommonResult userRegister(Map map);

    CommonResult selectUserInfoByIdNo(String idNo);

    CommonResult list();

    CommonResult checkUserAndPass(Map map);
}
