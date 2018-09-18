package net.orangepeels.redis.controller;

import net.orangepeels.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class RedisController {
    private final RedisService redisService;

    @Autowired
    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @RequestMapping(value = "/redis/get/{key}")
    public List<String> redisGetKey(@PathVariable("key") String key){
        return redisService.getValue(key);
    }

    @RequestMapping(value = "/redis/list/keys")
    public Set<String> redisListKeys(){
        return redisService.getAllKeys();
    }

    @RequestMapping(value = "/redis/get/{key}/type")
    public String redisGetKeyType(@PathVariable("key") String key){
        return redisService.getType(key);
    }
}
