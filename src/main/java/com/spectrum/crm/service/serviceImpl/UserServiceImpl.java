package com.spectrum.crm.service.serviceImpl;

import com.spectrum.crm.dao.UserDao;
import com.spectrum.crm.data.User;
import com.spectrum.crm.service.UserService;
import com.spectrum.crm.util.CommonResult;
import com.spectrum.crm.util.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;
    private SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public CommonResult userRegister(Map map) {

        String idNo = MapUtil.getStringKeyValues(map, "idNo");
        String idType = MapUtil.getStringKeyValues(map, "idType");
        String custName = MapUtil.getStringKeyValues(map, "custName");
        String mobile = MapUtil.getStringKeyValues(map, "mobile");
        String email = MapUtil.getStringKeyValues(map, "email");
        String age = MapUtil.getStringKeyValues(map, "age");
        String sex = MapUtil.getStringKeyValues(map, "sex");
        User oldUser = userDao.selectUserInfoByIdNo(idNo);
        Map resultMap = new HashMap();
        if (StringUtils.isEmpty(oldUser)) {
            logger.info("该用户不存在客户信息,保存客户信息");
            User user = new User();
            user.setId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
            user.setIdNo(idNo);
            user.setIdType(idType);
            user.setCustName(custName);
            user.setMobile(mobile);
            user.setEmail(email);
            user.setAge(age);
            user.setSex(sex);
            user.setInsertTime(simpleDateFormat.format(new Date()));
            userDao.insert(user);
            resultMap.put("id", user.getId());
        } else {
            logger.info("该用户已存在客户信息,进行更新信息");
            oldUser.setIdNo(idNo);
            oldUser.setIdType(idType);
            oldUser.setCustName(custName);
            oldUser.setMobile(mobile);
            oldUser.setEmail(email);
            oldUser.setAge(age);
            oldUser.setSex(sex);
            oldUser.setUpdateTime(simpleDateFormat.format(new Date()));
            userDao.updateById(oldUser);
            resultMap.put("id", oldUser.getId());
        }
        return new CommonResult<>(resultMap);
    }

    @Override
    public CommonResult selectUserInfoByIdNo(String idNo) {

        User user = userDao.selectUserInfoByIdNo(idNo);
        return new CommonResult<>(user);
    }

    @Override
    public CommonResult list() {
        List<User> userList = userDao.list();
        logger.info("查询成功");
        return new CommonResult<>(userList);
    }
}
