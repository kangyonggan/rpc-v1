package com.kangyonggan.rpc.service.impl;

import com.kangyonggan.rpc.service.MathService;

/**
 * @author kangyonggan
 * @since 2019-02-13
 */
public class MathServiceImpl implements MathService {

    public Integer add(int x, int y) {
        return x + y;
    }
}
