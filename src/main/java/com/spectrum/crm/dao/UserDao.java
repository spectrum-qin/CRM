package com.spectrum.crm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spectrum.crm.data.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao extends BaseMapper<User> {

    User selectUserInfoByIdNo(String idNo);

    User selectUserInfoByUserName(String userName);

    List<User> list();
}
