package net.orangepeels.utils;

import java.util.Collection;
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
        reStr = branch(item);
        return reStr;
    }

    private static  <T> String getJSON(Collection<T> list) {
        String reStr = "";
        reStr += "[";
        for (T item:
             list) {
            reStr += branch(item);
            reStr += ",";
        }
        reStr = reStr.substring(0, reStr.length()-1);
        reStr += "]";
        return reStr;
    }

    private static  <T> String getJSON(Map<String, T> list) {
        String reStr = "";
        Set<Map.Entry<String, T>> setList = list.entrySet();
        reStr += "{";
        for (Map.Entry<String, T> item:
             setList) {
            reStr += "\"" + item.getKey() + "\":";
            reStr += branch(item.getValue());
            reStr += ",";
        }
        reStr = reStr.substring(0, reStr.length()-1);
        reStr += "}";
        return reStr;
    }

    private static String getJSON(Object item){
        return "\"" + item.toString() + "\"";
    }

    /**
     * 用于来选择分支遍历，感觉不太对啊
     * @param item
     * @param <T>
     * @return
     */
    private static <T> String branch(T item){
        String reStr = "";
        reStr = item.toString();
        if(Collection.class.isAssignableFrom(item.getClass())){
            reStr = getJSON((Collection)item);
        }else if(Map.class.isAssignableFrom(item.getClass())){
            reStr = getJSON((Map)item);
        }else {
            reStr = getJSON(item);
        }
        return reStr;
    }

}
