package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * ClassName: UserService
 * Package: com.sky.service
 * Description:
 *
 * @Author han
 * @Create 2024/2/26  14:23
 * Version 1.0
 */
public interface UserService {
    User wxLogin(UserLoginDTO userLoginDTO);
}
