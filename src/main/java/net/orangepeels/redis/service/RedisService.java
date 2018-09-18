package net.orangepeels.redis.service;

import java.util.Map;
import java.util.Set;

public interface RedisService {
    Set<String> getAllKeys();
    Map<String, Object> getValue(String key);
    String getType(String key);
}
