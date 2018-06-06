package net.orangepeels.utils.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 用来格式化为json的类
 */
public class JSONTools {
    private JSONTools() {
        //防止实例化该工具类
    }

    /**
     * toJSON的入口方法，尝试使用泛型来解决问题
     *
     * @param item 进来的参数，按理说可以是任何类型
     * @param <T>  定义泛型，按理说可以是任意类型
     * @return json字符串
     */
    public static <T> String toJSON(T item) {
        String reStr = branch(item);
        return reStr;
    }

    /**
     * 把Collection接口下面那几个哥们儿转化为JSON格式
     */
    private static <T> String getJSON(Collection<T> list) {
        StringBuilder reStr = new StringBuilder();
        reStr.append("[");
        for (T item :
                list) {
            reStr.append(branch(item));
            reStr.append(",");
        }
        reStr = new StringBuilder(reStr.substring(0, reStr.length() - 1));
        reStr.append("]");
        return reStr.toString();
    }

    /**
     * 把Map转化为JSON格式
     */
    private static <T> String getJSON(Map<String, T> list) {
        StringBuilder reStr = new StringBuilder();
        Set<Map.Entry<String, T>> setList = list.entrySet();
        reStr.append("{");
        for (Map.Entry<String, T> item :
                setList) {
            reStr.append("\"").append(item.getKey()).append("\":");
            reStr.append(branch(item.getValue()));
            reStr.append(",");
        }
        reStr = new StringBuilder(reStr.substring(0, reStr.length() - 1));
        reStr.append("}");
        return reStr.toString();
    }

    /**
     * 该死的最复杂情况，有可能是数据对象，有可能是bean对象
     */
    private static String getJSON(Object obj) {
        StringBuilder reStr = new StringBuilder();
        Class<?> cs = obj.getClass();
        //数值类型不做操作
        if ( cs == Byte.class || cs == Integer.class || cs == Long.class
                || cs == Float.class || cs == Double.class
                || cs == Boolean.class) {
            reStr.append(obj.toString());
        }
        //字符串和字符类型加个引号
        if (cs == Character.class || cs == String.class) {
            reStr.append("\"");
            reStr.append(obj.toString());
            reStr.append("\"");
        } else { //处理bean对象
            Method[] list2 = cs.getMethods();
            reStr.append("{");
            for (Method item :
                    list2) {
                if (item.getName().contains("get") && !"getClass".equals(item.getName())) {
                    try {
                        reStr.append("\"").append(item.getName().substring(3, item.getName().length()).toLowerCase()).append("\":\"").append(item.invoke(obj)).append("\"");
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    reStr.append(",");
                }
            }
            reStr = new StringBuilder(reStr.substring(0, reStr.length() - 1));
            reStr.append("}");
        }
        return reStr.toString();
    }

    /**
     * 用于来选择分支遍历
     */
    private static <T> String branch(T item) {
        String reStr;
        if (Collection.class.isAssignableFrom(item.getClass())) {
            reStr = getJSON((Collection) item);
        } else if (Map.class.isAssignableFrom(item.getClass())) {
            reStr = getJSON((Map) item);
        } else {
            reStr = getJSON(item);
        }
        return reStr;
    }

}
