package net.orangepeels.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
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
     *
     * @param item 进来的参数，按理说可以是任何类型
     * @param <T>  定义泛型，按理说可以是任意类型
     * @return
     */
    public static <T> String toJSON(T item) {
        String reStr = "";
        reStr = branch(item);
        return reStr;
    }

    /**
     * 把Collection接口下面那几个哥们儿转化为JSON格式
     *
     * @param list
     * @param <T>
     * @return
     */
    private static <T> String getJSON(Collection<T> list) {
        String reStr = "";
        reStr += "[";
        for (T item :
                list) {
            reStr += branch(item);
            reStr += ",";
        }
        reStr = reStr.substring(0, reStr.length() - 1);
        reStr += "]";
        return reStr;
    }

    /**
     * 把Map转化为JSON格式
     *
     * @param list
     * @param <T>
     * @return
     */
    private static <T> String getJSON(Map<String, T> list) {
        String reStr = "";
        Set<Map.Entry<String, T>> setList = list.entrySet();
        reStr += "{";
        for (Map.Entry<String, T> item :
                setList) {
            reStr += "\"" + item.getKey() + "\":";
            reStr += branch(item.getValue());
            reStr += ",";
        }
        reStr = reStr.substring(0, reStr.length() - 1);
        reStr += "}";
        return reStr;
    }

    /**
     * 该死的最复杂情况，有可能是数据对象，有可能是bean对象
     *
     * @param obj
     * @return
     */
    private static String getJSON(Object obj) {
        String reStr = "";
        Class<?> cs = obj.getClass();
        //数值类型不做操作
        if ( cs == Byte.class || cs == Integer.class || cs == Long.class
                || cs == Float.class || cs == Double.class
                || cs == Boolean.class) {
            reStr += obj.toString();
        }
        //字符串和字符类型加个引号
        if (cs == Character.class || cs == String.class) {
            reStr += "\"";
            reStr += obj.toString();
            reStr += "\"";
        } else { //处理bean对象
            Method[] list2 = cs.getMethods();
            reStr += "{";
            for (Method item :
                    list2) {
                if (item.getName().indexOf("get") != -1 && !"getClass".equals(item.getName())) {
                    try {
                        reStr += "\"" + item.getName() + "\":\"" + item.invoke(obj) + "\"";
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    reStr += ",";
                }
            }
            reStr = reStr.substring(0, reStr.length() - 1);
            reStr += "}";
        }
        return reStr;
    }

    /**
     * 用于来选择分支遍历
     *
     * @param item
     * @param <T>
     * @return
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
