package net.orangepeels.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

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
    public String getValue(String key) {
        String type = jedis.type(key);
        String reTempStr = "";
        if("sting".equals(type)){
            reTempStr = jedis.get(key);
        }
        if("list".equals(type)){
            reTempStr = jedis.lpop(key);
        }
        return reTempStr;
    }

    @Override
    public String getType(String key) {
        return jedis.type(key);
    }


}
