package com.springmvc.proxy;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.proxy
 * @ClassName: TestOne
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/10/18 20:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/10/18 20:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TestOne {
    public static void main(String[] args) {

        //使用CGLib动态代理
        CglibProxy cglibProxy = new CglibProxy();
        System.out.println(cglibProxy.getClass());
        ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
        System.out.println(forumService.getClass());
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
