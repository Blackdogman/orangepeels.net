package net.orangepeels.redis.service;

import java.util.Map;
import java.util.Set;

public interface RedisService {
    /**
     * 得到redis中所有的key
     * @return 装有redis中所有key的Set
     */
    Set<String> getAllKeys();
    /**
     * 得到redis中对应的key的值
     * @param key redis中的key值
     * @return 返回一个{key: value}的Map对象
     */
    Map<String, Object> getValue(String key);
    /**
     * 得到对应key的type
     * @param key redis中的key值
     * @return 对应key值得对象类型(string, list, hash....)
     */
    String getType(String key);
}
