package com.kangyonggan.rpc.handler;

import com.kangyonggan.rpc.pojo.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 各种负载均衡的实现
 *
 * @author kangyonggan
 * @since 2019-02-15
 */
public class LoadBalanceHandler {

    /**
     * 引用调用次数
     */
    private static Map<String, Long> refInvokeTimes = new HashMap<>();

    /**
     * 引用次数加一
     *
     * @param refrenceName
     * @return
     */
    public static synchronized Long incInvokeTimes(String refrenceName) {
        Long count = refInvokeTimes.get(refrenceName);
        if (count == null) {
            count = 0L;
        }
        count++;
        refInvokeTimes.put(refrenceName, count);
        return count;
    }

    /**
     * 轮询
     *
     * @param services
     * @param index
     * @return
     */
    public static Service getPollService(List<Service> services, Long index) {
        return services.get((int) (index % services.size()));
    }

    /**
     * 随机
     *
     * @param services
     * @return
     */
    public static Service getRandomService(List<Service> services) {
        // 随机
        int random = new Random().nextInt(services.size());
        return services.get(random);
    }

}
