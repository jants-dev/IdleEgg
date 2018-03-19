package team.ants.shop.controller.common;

import cn.jants.common.annotation.action.Controller;
import cn.jants.common.annotation.action.GET;
import cn.jants.common.annotation.action.POST;
import cn.jants.common.annotation.action.Param;
import cn.jants.common.annotation.service.Autowired;
import cn.jants.restful.render.Json;
import team.ants.shop.service.system.SysConfigService;

import java.util.Map;

/**
 * @author MrShun
 * @version 1.0
 */
@Controller("config")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 根据Key查询配置
     *
     * @param name 配置键
     * @return
     */
    @GET("/get")
    public Map getConfig(@Param String name) {
        return Json.success(sysConfigService.getConfig(name));
    }


    /**
     * 根据Key查询配置, 中的某个文本
     *
     * @param name 配置键
     * @param key  值键
     * @return
     */
    @GET("/getVal")
    public Map getConfig(@Param String name, @Param String key) {
        return Json.success(sysConfigService.getVal(name, key));
    }

    /**
     * 修改配置信息
     *
     * @return
     */
    @POST("/update")
    public Map updateConfig(String name, String content) {
        sysConfigService.updateConfig(name, content);
        return Json.success("");
    }


    /**
     * 修改配置键值信息
     *
     * @return
     */
    @POST("/updateVal")
    public Map updateConfigVal(String name, String content) {
        sysConfigService.updateVal(name, content);
        return Json.success("");
    }
}
