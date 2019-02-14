package com.kangyonggan.rpc.pojo;

import lombok.Data;

/**
 * @author kangyonggan
 * @since 2019/2/13 0013
 */
@Data
public class BaseService {

    private String id;

    private String name;

    private String impl;

    private String ref;

    private String version;

    private int weight;

    private String applicationName;

    private String ip;

    private int port;

}
