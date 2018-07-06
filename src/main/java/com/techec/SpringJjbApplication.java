package com.techec;


        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.techec.dao")
@EnableCaching // 启动缓存
public class SpringJjbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJjbApplication.class, args);
    }
}
