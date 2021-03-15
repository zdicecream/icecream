package com.zdinit.icecream.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;
/**
 * 自定义ID生成器,mp默认是雪河算法，可以不开启
 */
@Slf4j
@Component
public class IdGenerator implements IdentifierGenerator {

    @Override
    public Long nextId(Object entity) {
        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
        String bizKey = entity.getClass().getName();
        log.debug("bizKey:{}", bizKey);
        final long id = Long.parseLong(LocalDateTime.now().toString());
        log.debug("为生成主键值->:{}", id);
        return id;
    }

}
