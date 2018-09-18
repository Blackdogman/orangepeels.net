package net.orangepeels.redis.service;

import java.util.Set;

public interface RedisService {
    Set<String> getAllKeys();
    String getValue(String key);
    String getType(String key);
}
