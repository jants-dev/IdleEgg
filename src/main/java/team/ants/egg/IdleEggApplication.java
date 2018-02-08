package team.ants.egg;

import cn.jants.common.annotation.boot.PropertyConfiguration;
import cn.jants.common.annotation.plugin.EnableSQLMapPlugin;
import cn.jants.common.annotation.service.Application;
import cn.jants.core.startup.JTomcat;

/**
 * IdleEgg应用启动类
 *
 * @author MrShun
 * @version 1.0
 */
@Application
@PropertyConfiguration(domain = "*")
@EnableSQLMapPlugin(value = "team/ants/egg/mapper")
public class IdleEggApplication {

    public static void main(String[] args) {
        JTomcat.run(IdleEggApplication.class, 80, "/api");
    }
}
