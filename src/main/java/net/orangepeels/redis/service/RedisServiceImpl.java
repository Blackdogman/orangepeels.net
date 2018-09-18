package net.orangepeels.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.*;

@Service
public class RedisServiceImpl implements RedisService {
    private final Jedis jedis;

    @Autowired
    public RedisServiceImpl(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public Set<String> getAllKeys() {
        return jedis.keys("*");
    }

    @Override
    public Map<String, Object> getValue(String key) {
        String type = jedis.type(key); // 得到key所对应的对象类型
        Map<String, Object> reMap = new HashMap<>();
        if("string".equals(type)){
            reMap.put(key, jedis.get(key));
        }
        if("list".equals(type)){
            reMap.put(key, jedis.lrange(key, 0, 999));
        }
        if("hash".equals(type)){
            reMap.putAll(jedis.hgetAll(key));
        }
        return reMap;
    }

    @Override
    public String getType(String key) {
        return jedis.type(key);
    }
}
