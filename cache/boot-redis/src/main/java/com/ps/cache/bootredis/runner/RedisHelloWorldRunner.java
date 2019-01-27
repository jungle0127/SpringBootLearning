package com.ps.cache.bootredis.runner;

import com.ps.cache.bootredis.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class RedisHelloWorldRunner implements CommandLineRunner {
    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;
//    @Autowired
//    private RedisTemplate<String,Object> objectRedisTemplate;
    @Override
    public void run(String... args) throws Exception {
        this.helloRedis();
        this.batchInsert();
//        this.pojoCheck();
    }

    private void helloRedis(){
        this.stringRedisTemplate.opsForValue().set("ps.key","Hello Redis");
        String result = this.stringRedisTemplate.opsForValue().get("ps.key").toString();
        System.out.println(result);
    }

    private void batchInsert(){
        List<String> dataList = new LinkedList<>();
        dataList.add("data1");
        dataList.add("data2");
        StringRedisSerializer stringRedisSerializer = (StringRedisSerializer) stringRedisTemplate.getKeySerializer();
        this.stringRedisTemplate.executePipelined(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                for(String item: dataList){
                    final byte[] rawKey = stringRedisSerializer.serialize("key."+item);
                    connection.set(rawKey,stringRedisSerializer.serialize("ps.lotus"));
                }
                return null;
            }
        });
        System.out.println(this.stringRedisTemplate.opsForValue().get("key.data1").toString());
    }

    public void pojoCheck(){
        Person person = new Person();
        person.setAddress("address");
        person.setUserName("usr");

//        this.objectRedisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
//        this.objectRedisTemplate.opsForValue().set("key.person",person);
//        person = (Person)this.objectRedisTemplate.opsForValue().get("key.person");
        System.out.println(person.toString());
    }
}
