package org.testcontainers.junit.jupiter.inheritance;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;

public class RedisContainer extends GenericContainer<RedisContainer> {
    private String host;
    private Integer port;

    public RedisContainer(String host, Integer port) {
        super(DockerImageName.parse("bitnami/redis:6.2"));
        this.host=host;
        this.port=port;
        withExposedPorts(port);
        withEnv("ALLOW_EMPTY_PASSWORD", "yes");
    }

    public Jedis getJedis() {
        return new Jedis(host, getMappedPort(port));
    }

}