package com.ps.cache.bootredis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.LinkedList;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;
import static org.springframework.util.StringUtils.split;

public class LettuceConfiguration {
    @Value("${redis.cluster.nodes}")
    private String redisClusterNode;
    @Value("${redis.cluster.password")
    private String redisPassword;
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        redisClusterConfiguration.setPassword(null);
        Iterable<RedisNode> redisNodes = new LinkedList<>();
        String[] clusterNodes = this.redisClusterNode.split(",");
        for(String nodeInfo: clusterNodes){
            ((LinkedList<RedisNode>) redisNodes).add(this.readHostAndPortFromString(nodeInfo));
        }
        redisClusterConfiguration.setClusterNodes(redisNodes);
        return new LettuceConnectionFactory();
    }
    private RedisNode readHostAndPortFromString(String hostAndPort) {

        String[] args = split(hostAndPort, ":");

        notNull(args, "HostAndPort need to be seperated by  ':'.");
        isTrue(args.length == 2, "Host and Port String needs to specified as host:port");
        return new RedisNode(args[0], Integer.valueOf(args[1]));
    }
    @Bean(value = "redisTemplate")
    public RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }
}
