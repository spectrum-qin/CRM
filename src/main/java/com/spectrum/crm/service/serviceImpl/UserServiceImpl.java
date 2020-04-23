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
        String userName = MapUtil.getStringKeyValues(map, "userName");
        String mobile = MapUtil.getStringKeyValues(map, "mobile");
        String pass = MapUtil.getStringKeyValues(map, "pass");
        User oldUser = userDao.selectUserInfoByIdNo(idNo);
        Map resultMap = new HashMap();
        if (StringUtils.isEmpty(oldUser)) {
            logger.info("注册新用户,保存用户信息");
            User user = new User();
            user.setId(UUID.randomUUID().toString().trim().replaceAll("-", ""));
            user.setIdNo(idNo);
            user.setIdType(idType);
            user.setUserName(userName);
            user.setMobile(mobile);
            user.setPass(pass);
            user.setInsertTime(simpleDateFormat.format(new Date()));
            userDao.insert(user);
            resultMap.put("id", user.getId());
        } else {
            logger.info("修改密码,进行更新信息");
            oldUser.setIdNo(idNo);
            oldUser.setIdType(idType);
            oldUser.setUserName(userName);
            oldUser.setMobile(mobile);
            oldUser.setPass(pass);
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

    @Override
    public CommonResult checkUserAndPass(Map map) {
        String userId = MapUtil.getStringKeyValues(map, "name");
        String pass = MapUtil.getStringKeyValues(map, "pass");
        User user = userDao.selectUserInfoByUserName(userId);
        if (StringUtils.isEmpty(user)) {
            return new CommonResult("该用户不存在，请先注册再登录", "00001");
        } else {
            if (!Objects.equals(pass, user.getPass())) {
                return new CommonResult("用户名或密码错误，请重新输入", "00002");
            }
        }
        List<User> userList = userDao.list();
        logger.info("查询成功");
        return new CommonResult<>(userList);
    }
}
