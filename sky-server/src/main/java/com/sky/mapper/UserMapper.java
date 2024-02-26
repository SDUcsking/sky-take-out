package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName: UserMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author han
 * @Create 2024/2/26  14:57
 * Version 1.0
 */
@Mapper
public interface UserMapper {


        @Select("select * from user where openid=#{openid}")
        User getByOpenid(String openid);


    void insert(User user);
}
