package com.springmvc.proxy;

import java.lang.reflect.Proxy;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.proxy
 * @ClassName: Test
 * @Description: java类作用描述:jdk的动态代理技术
 * @Author: 焦关平
 * @CreateDate: 2018/10/18 20:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/18 20:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ForumService target = new ForumServiceImpl();
        System.out.println(target.getClass());
        PerformaceHandler handler = new PerformaceHandler(target);

        System.out.println(target.getClass().getInterfaces());
        System.out.println(target.getClass().getClassLoader());
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target
                        .getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        System.out.println("1111111111111111111111111111111111"+proxy.getClass());


        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }
}
