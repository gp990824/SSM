package com.gp.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author gp
 * @create 2020/2/2 12:27
 */

/**
 * mybatis的插件开发
 *      编写Interceptor的实现类
 *      使用@Intercepts注解完成插件的签名
 *      将写好的插件注册到全局配置文件中
 *      插件会产生目标对象的代理对象
 *      多个插件就会产生多层代理
 *      创建动态代理对象的时候,是按照插件配置顺序创建层层代理对象
 *      执行目标方法之后,按照逆向顺序执行
 *
 *      插件的执行流程:
 *          我们创建的插件为目标对象(type = StatementHandler.class)创建代理对象
 *          目标对象的目标方法(method = "parameterize")要执行的时候,都会来到插件的intercept方法
 *          只有让invocation.proceed()放行了,目标方法才能能执行
 *
 *      想要实现分页操作,可以去网上下载PageHandler插件,具体操作查看其文档
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "parameterize",args = {Statement.class})})
public class MyPlugin implements Interceptor {

    /**
     *
     * 拦截目标对象的目标方法的执行
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //偷梁换柱(改变SQL参数的值),本来传进来的参数时123456,让其改成526511
        Object target = invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(target);
        metaObject.setValue("parameterHandler.parameterObject",526511);
        System.out.println("intercept 方法已进入! " + invocation.getMethod());
        return invocation.proceed();
    }


    /**
     * 包装目标对象,为目标对象创建一个代理对象
     * @param target
     * @return 返回当前target创建的动态代理对象
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("plugin 方法已进入! 将要包装的对象为: " + target);
        //用Plugin对象的wrap方法来使用当前Interceptor包装我们的目标对象
        return Plugin.wrap(target,this);
    }

    /**
     * 将插件注册时的properties属性设置进来
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息:" + properties);
    }
}
