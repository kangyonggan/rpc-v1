package com.kangyonggan.rpc.util;

import com.kangyonggan.rpc.constants.RegisterType;
import com.kangyonggan.rpc.constants.RpcPojo;
import com.kangyonggan.rpc.pojo.Register;
import com.kangyonggan.rpc.pojo.Service;

/**
 * @author kangyonggan
 * @since 2019-02-14
 */
public final class RegisterUtils {

    private RegisterUtils() {
    }

    /**
     * 发布服务到注册中心
     *
     * @param service
     */
    public static void registerService(Service service) {
        Register register = (Register) SpringUtils.getApplicationContext().getBean(RpcPojo.register.name());

        if (RegisterType.zookeeper.name().equals(register.getType())) {
            // zookeeper
            String basePath = "/rpc/" + service.getName() + "/provider";
            String path = basePath + "/" + service.getIp() + "_" + service.getPort();

            ZookeeperClient client = ZookeeperClient.getInstance(register.getIp(), register.getPort());

            // 应用（路径）永久保存
            client.createPath(basePath);

            // 服务(数据)不永久保存，当与zookeeper断开连接20s左右自动删除
            client.saveNode(path, service);
        }

    }
}
