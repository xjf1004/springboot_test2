package com.xjf.springboot_test.handle;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Refrain_ouc
 * @create 2021-07-21 10:15
 * 注册乐观锁的配置，需要开启事务，开启mapper扫描，是个配置类，MP的所有配置都可以写在这里
 */

@EnableTransactionManagement
@Configuration
@MapperScan("com.xjf.springboot_test.Mapper")
public class MybatisPlusConfiguration {

    @Bean
    //开启乐观锁的bean
    public MybatisPlusInterceptor MybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }


}
