package net.orangepeels.utils;

import org.omg.CORBA.Object;

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
        return "";
    }

    private static <T> String toJSON(List<T> list) {
        String reStr = "";
        for (T item :
                list) {

        }
        return reStr;
    }

    private static <T> String toJSON(Set<T> list) {
        return "";
    }

    private static <T> String toJSON(Map<String, T> list) {
        return "";
    }
}