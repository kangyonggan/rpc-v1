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
            //创建[永久保留，不删除]节点
//            ZookeeperClient.getInstance().createOrUpdateNodePersistent(basePath, null);
            //创建临时节点
//            ZookeeperClient.getInstance().createOrUpdateNode(path, baseService);
        }

    }
}
