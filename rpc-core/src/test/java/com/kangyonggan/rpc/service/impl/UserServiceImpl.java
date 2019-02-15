package com.kangyonggan.rpc.service.impl;

import com.kangyonggan.rpc.service.UserService;

/**
 * @author kangyonggan
 * @since 2019-02-15
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean exists(String username) {
        return "rpc".equals(username);
    }
}
