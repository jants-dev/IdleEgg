package team.ants.egg.handler;

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
    public boolean preHandler(String target, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return false;
    }
}
