package com.kangyonggan.rpc.xsd.pojo;

import lombok.Data;

/**
 * @author kangyonggan
 * @since 2019-02-13
 */
@Data
public class Register {

    private String id;

    private String type;

    private String ip;

    private String port;

    private String username;

    private String password;

}
