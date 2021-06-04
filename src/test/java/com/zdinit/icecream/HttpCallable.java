package com.zdinit.icecream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zdinit.icecream.common.utils.HttpClientUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 异步执行HTTP请求
 */
public class HttpCallable implements Callable<String> {

    private String url;

    private String jsonParams;

    public HttpCallable(String url, String jsonParams) {
        this.url = url;
        this.jsonParams = jsonParams;
    }

    /**
     * 执行并返回结果
     */
    @Override
    public String call() throws Exception {
        return HttpClientUtil.requestGet(url, jsonParams);
    }

    /**
     * 模拟并发测试
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //模拟并发数
        int concurrencyNumber = 50;

        List<String> resList = Lists.newArrayList();

        //执行线程池
        ExecutorService ex = Executors.newFixedThreadPool(5);

        String url ="http://127.0.0.1:8088/api/sys/t-resource/getOne";
        Map<String, String> mapPatam = new HashMap<>();



        for (int i = 0; i < concurrencyNumber; i++) {
            Future<String> callRes = ex.submit(new HttpCallable(url, JSON.toJSONString(mapPatam)));
            resList.add(i + ">>>" + callRes.get());
        }

        for (String s : resList) {
            System.out.println("------>" + s);
        }
    }

}