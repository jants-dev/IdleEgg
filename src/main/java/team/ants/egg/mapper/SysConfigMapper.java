package team.ants.egg.mapper;

import cn.jants.common.bean.JsonMap;
import cn.jants.plugin.sqlmap.annotation.Mapper;
import cn.jants.plugin.sqlmap.annotation.P;

/**
 * @author MrShun
 * @version 1.0
 */
@Mapper
public interface SysConfigMapper {

    /**
     * 根据key查询值
     *
     * @param key
     * @return
     */
    JsonMap selectByKey(String key);

    /**
     * 根据Key修改值
     *
     * @param key 键
     * @param val 值
     */
    void updateByKey(@P("key") String key, @P("val") String val);
}
