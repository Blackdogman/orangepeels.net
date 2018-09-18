package net.orangepeels.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public List<String> getValue(String key) {
        String type = jedis.type(key);
        List<String> reList = new ArrayList<>();
        if("string".equals(type)){
            reList.add(jedis.get(key));
        }
        if("list".equals(type)){
            reList.addAll(jedis.lrange(key, 0, 999));
        }
        return reList;
    }

    @Override
    public String getType(String key) {
        return jedis.type(key);
    }
}
