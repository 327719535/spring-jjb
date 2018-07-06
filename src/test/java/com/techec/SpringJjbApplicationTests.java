package com.techec;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJjbApplicationTests {
    public static final String GIRL = "lin:";
    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void contextLoads() {


    }




    /**
     * 通过id查询，如果查询到则进行缓存
     *
     * @param实体类id
     * @return 查询到的实现类
     */
    @Test
    public void findOne() {
     /*   String key = "1";
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) { // 从缓存中取
            User girl = (User) redisTemplate.opsForValue().get(key);
            System.err.println("从缓存中获取了用户！" + girl);

        }
        // 从数据库取，并存回缓存
        User girl = uRoleMapper.selectByPrimaryKey("1");
        // 放入缓存，并设置缓存时间
        redisTemplate.opsForValue().set(key, girl, 600, TimeUnit.SECONDS);*/

    }


    /**
     * 更新用户
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     *
     * @paramuser用户
     */
    @Test
    public void updateUser() {
      /*  User User = new User();
        User.setId("1");
        User.setNickname("测试！");
        User.setEmail("2");
        System.err.println("更新用户start...");
        uRoleMapper.updateByPrimaryKey(User);
        String userId = User.getId();
        // 缓存存在，删除缓存
        String key = userId;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            System.err.println("更新用户时候，从缓存中删除用户 >> " + userId);
        }*/
    }

    /**
     * 删除用户
     * 如果缓存中存在，删除
     */
    //@Test
    public void deleteById() {
      /*  System.err.println("删除用户start...");
        uRoleMapper.deleteByPrimaryKey("3");

        // 缓存存在，删除缓存
        String key = "user_" + 3;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            System.err.println("删除用户时候，从缓存中删除用户 >> ");
        }*/
    }


}
