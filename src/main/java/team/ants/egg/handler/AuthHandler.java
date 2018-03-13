package team.ants.egg.handler;

import cn.jants.common.bean.Log;
import cn.jants.core.ext.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限处理器
 *
 * @author MrShun
 * @version 1.0
 */
public class AuthHandler implements Handler {

    @Override
    public boolean preHandler(String target, HttpServletRequest request, HttpServletResponse response) {
        Log.debug("暂时不做权限处理, 放过拦截.....");
        return true;
    }
}
