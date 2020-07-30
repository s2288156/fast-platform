package com.fp.user.dao.jpa;

import com.fp.tool.util.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.AbstractUUIDGenerator;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * 自定义主键生成策略
 *
 * @author wcy
 * @date 2019/11/8
 */
@Slf4j
public class CustomIdGenerator extends AbstractUUIDGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        // 解决自定义主键
        Object id =  getIdFiled(o);
        if (id != null) {
            return (Serializable) id;
        }
        return IdWorker.getIdStr();
    }

    private Object getIdFiled(Object o) {
        try {
            String firstLetter = "id".substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + "id".substring(1);
            Method method = o.getClass().getMethod(getter);
            return method.invoke(o);
        } catch (Exception e) {
            return null;
        }
    }
}
