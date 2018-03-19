package team.ants.shop;

import cn.jants.common.annotation.boot.PropertyConfiguration;
import cn.jants.common.annotation.plugin.EnableSQLMapPlugin;
import cn.jants.common.annotation.service.Application;
import cn.jants.core.context.AppConfiguration;
import cn.jants.core.context.AppConstant;
import cn.jants.core.module.HandlerManager;
import cn.jants.core.startup.JTomcat;
import team.ants.shop.handler.AuthHandler;

/**
 * IdleEgg应用启动类
 *
 * @author MrShun
 * @version 1.0
 */
@Application
@PropertyConfiguration(domain = "*")
@EnableSQLMapPlugin(value = "team/ants/shop/mapper")
public class ShopApplication extends AppConfiguration{

    //添加权限拦截
    @Override
    public void configHandler(HandlerManager handlers) {
        handlers.add(new AuthHandler());
    }

    public static void main(String[] args) {
        // 模拟输入参数
        args = new String[]{"80", "admin-api"};
        int port = 80;
        String contextPath = "";
        if(args.length == 1){
            port = Integer.valueOf(args[0]);
        }else if(args.length == 2){
            //App 接口
            if("open-api".equals(args[1])){
                contextPath = "/api";
                AppConstant.FILTER_PACKAGES = new String[]{".admin", ".web"};
            }
            //PC前端
            else if("web-api".equals(args[1])){
                contextPath = "";
                AppConstant.FILTER_PACKAGES = new String[]{".open", ".admin"};
            }
            //PC管理端
            else if("admin-api".equals(args[1])){
                contextPath = "/admin";
                AppConstant.FILTER_PACKAGES = new String[]{".open", ".web"};
            }
        }
        JTomcat.run(ShopApplication.class, port, contextPath);
    }
}
