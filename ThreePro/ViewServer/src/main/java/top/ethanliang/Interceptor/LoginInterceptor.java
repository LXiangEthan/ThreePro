package top.ethanliang.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * @ author ethan     * @ date  2024年07月30日 下午8:29
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("此处需要验证token或者session");
        HttpSession session = request.getSession();
        Object time = session.getAttribute("SessionTime");
        if(time == null) {
            response.sendRedirect("/index.html");
            return false;
        }
        else {
            long sTime = (long)time;
            if(sTime < Calendar.getInstance().getTimeInMillis()){
                response.sendRedirect("/index.html");
                return false;
            }
            else{
                session.setAttribute("SessionTime", Calendar.getInstance().getTimeInMillis() + (1000 * 60 * 60));
                return true;
            }

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("此处可以处理日志");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("此处存放系统日志");
    }
}