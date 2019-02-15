package com.kangyonggan.rpc.service;

/**
 * @author kangyonggan
 * @since 2019-02-15
 */
public interface UserService {

    /**
     * 判断用户是否存在
     *
     * @param username
     * @return
     */
    boolean exists(String username);

}
