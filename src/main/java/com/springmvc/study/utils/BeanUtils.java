package com.springmvc.study.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 进行bean的浅复制，但是潜复制会带来一个问题，如果里面包含对象是就会只复制对象的应用地址，水机的数据不会发上改变
 * @author HSHY-394
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

    /**
     * 单对象模型转换
     * @param t
     * @param clazz
     * @param <M>
     * @param <T>
     * @return
     */
    public static <M, T> M toSingleModel(T t, Class<M> clazz) {
        M m = null;
        try {
            m = clazz.newInstance();
            if (t != null) {
                copyProperties(t, m);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            return m;
        }
    }

    /**
     * 集合对象模型转换
     * @param list
     * @param clazz
     * @param <M>
     * @param <T>
     * @return
     */
    public static <M, T> List<M> toListModel(List<T> list, Class<M> clazz) {
        if (list != null && list.size() > 0) {
            List<M> modelList = Lists.newArrayList();
            for (T t : list) {
                modelList.add(toSingleModel(t, clazz));
            }
            return modelList;
        }
        return Lists.newArrayList();
    }

}
