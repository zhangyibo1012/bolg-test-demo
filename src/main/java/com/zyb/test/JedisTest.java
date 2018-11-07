package com.zyb.test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title: JedisTest.java
 * @Package com.zyb.test
 * @Description: TODO
 * @Author ZhangYB
 * @Version V1.0
 */
public class JedisTest {

    public static void main(String[] args) {
        try {
            jedisPool();
            jedisCluster ();
        } catch (Exception e) {

        }
    }

    public static void jedisPool() throws Exception{
        // 创建连接池对象  host port
        JedisPool jedisPool = new JedisPool("192.168.32.133" , 6379);

        // 从连接处获得一个jedis对象
        Jedis jedis = jedisPool.getResource();

        //set
        jedis.set("TestPool" , "Yes");
        String value = jedis.get("TestPool");
        System.err.println(value);

        // 关闭连接 连接池回收资源
        jedis.close();

        // close jedisPool
        jedisPool.close();
    }

    public static void jedisCluster() throws Exception{

        // jedisCluster 对象 ,参数nodes是Set类型,包含若干个HostAndPort对象
        Set<HostAndPort> nodes = new HashSet<>(16);
        nodes.add(new HostAndPort("192.168.32.133" , 7001));
        nodes.add(new HostAndPort("192.168.32.133" , 7002));
        nodes.add(new HostAndPort("192.168.32.133" , 7003));
        nodes.add(new HostAndPort("192.168.32.133" , 7004));
        nodes.add(new HostAndPort("192.168.32.133" , 7005));
        nodes.add(new HostAndPort("192.168.32.133" , 7006));

        JedisCluster jedisCluster = new JedisCluster(nodes);

        // jedisCluster操作redis集群
        jedisCluster.set("jedisCluster" , "OK");
        System.err.println(jedisCluster.get("jedisCluster"));

        // close
        jedisCluster.close();


    }
}
