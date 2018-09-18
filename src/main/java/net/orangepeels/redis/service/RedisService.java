package net.orangepeels.redis.service;

import java.util.List;
import java.util.Set;

public interface RedisService {
    Set<String> getAllKeys();
    List<String> getValue(String key);
    String getType(String key);
}
