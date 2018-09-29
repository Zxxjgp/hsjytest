package com.springmvc.thread;

import org.jetbrains.annotations.NotNull;

/**
 * @ProjectName: hsjytest
 * @Package: com.springmvc.thread
 * @ClassName: Indo
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/9/20 15:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/9/20 15:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Indo implements Comparable<Indo>{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int compareTo(@NotNull Indo o) {
        return 0;
    }
}
