package net.orangepeels.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用来格式化为json的类
 */
public class JSONtools {
    private JSONtools() {
        //防止实例化该工具类
    }

    /**
     * toJSON的入口方法，尝试使用泛型来解决问题
     * @param item 进来的参数，按理说可以是任何类型
     * @param <T> 定义泛型，按理说可以是任意类型
     * @return
     */
    public static <T> String toJSON(T item){
        String reStr = "";


        return "";
    }

    private static  <T> String toJSON(List<T> list) {
        System.out.println("调用了List<T>");
        System.out.println(list);
        return "";
    }

    private static  <T> String toJSON(Set<T> list) {
        return "";
    }

    private static  <T> String toJSON(Map<String, T> list) {
        return "";
    }

    /**
     * 用于来选择分支遍历，感觉不太对啊
     * @param item
     * @param <T>
     * @return
     */
    private static <T> String branch(T item){
        String reStr = "";
        if(List.class.isAssignableFrom(item.getClass())){
            reStr = toJSON((List)item);
        }
        if(Set.class.isAssignableFrom(item.getClass())){
            reStr = toJSON((Set)item);
        }
        if(Map.class.isAssignableFrom(item.getClass())){
            reStr = toJSON((Map)item);
        }
        reStr = toJSON(item);
        return reStr;
    }

}
