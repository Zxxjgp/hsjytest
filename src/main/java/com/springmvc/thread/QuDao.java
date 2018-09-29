package com.springmvc.thread;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.thread
 * @ClassName: QuDao
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/20 15:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/20 15:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class QuDao {
    private static final ThreadLocal<Indo> TH = new ThreadLocal<>();
    private QuDao(){}
    public static void setIndo(Indo indo){
        TH.set(indo);
    }
    public static void send (){
        System.out.println("线程"+Thread.currentThread().getName()+"发送消息"+TH.get().getMsg());
    }

}
