package com.springmvc.thread;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.thread
 * @ClassName: TestThread
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/20 15:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/20 15:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TestThread {
    public static void main(String[] args) {
        new Thread(() ->{
            Indo  in = new Indo();
            in.setMsg("第一个");
            QuDao.setIndo(in);
            QuDao.send();
        },"线程A").start();

        new Thread(() ->{
            Indo  in = new Indo();
            in.setMsg("第二个");
            QuDao.setIndo(in);
            QuDao.send();
        },"线程B").start();

        new Thread(() ->{
            Indo  in = new Indo();
            in.setMsg("第三个");
            QuDao.setIndo(in);
            QuDao.send();
        },"线程C").start();

    }
}
