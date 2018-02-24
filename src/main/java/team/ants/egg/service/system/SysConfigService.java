package team.ants.egg.service.system;

import cn.jants.common.annotation.service.Autowired;
import cn.jants.common.annotation.service.Service;
import cn.jants.common.bean.JsonMap;
import cn.jants.common.exception.TipException;
import com.alibaba.fastjson.JSON;
import team.ants.egg.mapper.SysConfigMapper;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author MrShun
 * @version 1.0
 */
@Service
public class SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    /**
     * 根据配置名称获取值
     *
     * @param name
     * @return
     */
    public JsonMap getConfig(String name) {
        JsonMap data = sysConfigMapper.selectByKey(name);
        String jsonDate = data.getStr("val");
        JsonMap result = JSON.parseObject(jsonDate, JsonMap.class);
        return result;
    }


    /**
     * 根据配置名称获值中的键值
     *
     * @param name
     * @param key
     * @return
     */
    public String getVal(String name, String key) {
        JsonMap data = sysConfigMapper.selectByKey(name);
        String jsonDate = data.getStr("val");
        JsonMap result = JSON.parseObject(jsonDate, JsonMap.class);
        return result.getStr(key);
    }

    /**
     * 修改整个配置内容
     *
     * @param name
     * @param content
     */
    public void updateConfig(String name, String content) {
        sysConfigMapper.updateByKey(name, content);
    }

    /**
     * 修改整个配置内容中的某个json键值
     *
     * @param name
     * @param content
     */
    public void updateVal(String name, String content) {
        JsonMap jsonMap;
        try {
            jsonMap = JSON.parseObject(content, JsonMap.class);
        } catch (Exception e) {
            throw new TipException("错误, content必须是一个Json对象!");
        }
        JsonMap data = sysConfigMapper.selectByKey(name);
        String jsonDate = data.getStr("val");
        //使用TreeMap根据字母排序
        TreeMap configs = JSON.parseObject(jsonDate, TreeMap.class);
        Set<Map.Entry<String, Object>> sets = configs.entrySet();
        for (Map.Entry<String, Object> entry : sets) {
            String key = entry.getKey();
            Object val = jsonMap.get(key);
            if (val != null) {
                entry.setValue(val);
            }
        }
        sysConfigMapper.updateByKey(name, JSON.toJSONString(configs));
    }
}
