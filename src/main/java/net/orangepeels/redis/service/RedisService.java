package net.orangepeels.redis.service;

import java.util.Map;
import java.util.Set;

public interface RedisService {
//    得到redis中所有的key
    Set<String> getAllKeys();
//    得到对应key的value
    Map<String, Object> getValue(String key);
//    得到对应key的type
    String getType(String key);
}
