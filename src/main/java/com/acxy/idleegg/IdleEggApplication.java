package com.acxy.idleegg;

import cn.jants.common.annotation.boot.PropertyConfiguration;
import cn.jants.common.annotation.plugin.EnableSQLMapPlugin;
import cn.jants.common.annotation.service.Application;
import cn.jants.core.startup.JTomcat;

import java.lang.reflect.InvocationTargetException;

/**
 * IdleEgg应用启动类
 *
 * @author MrShun
 * @version 1.0
 */
@Application
@PropertyConfiguration
@EnableSQLMapPlugin(value = "com/acxy/idleegg/mapper")
public class IdleEggApplication {

    public static void main(String[] args) {
        JTomcat.run(IdleEggApplication.class, 80, "/api");
    }
}
