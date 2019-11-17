package group.geolo.defectmanager.interceptor;

import group.geolo.defectmanager.annotation.Auth;
import group.geolo.defectmanager.exception.AuthException;
import group.geolo.defectmanager.util.JwtAuthUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/13
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Auth classAuth = handlerMethod.getBeanType().getAnnotation(Auth.class);
        Auth methodAuth = handlerMethod.getMethodAnnotation(Auth.class);
        if (classAuth != null || methodAuth != null) {
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (token == null) {
                throw new AuthException(403, "client need an authorization.");
            }
            int userId = JwtAuthUtils.parseId(token);
            request.getSession().setAttribute("userId", userId);
        }
        return true;
    }
}
