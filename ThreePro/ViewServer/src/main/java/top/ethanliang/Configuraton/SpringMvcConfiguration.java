package top.ethanliang.Configuraton;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.ethanliang.Interceptor.LoginInterceptor;

@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {
    /**
     * @ author ethan
     * @ date  2024年08月27日 下午12:01
     * @ description  写下注释时请使用@变量名/方法名 描述
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/index.html","/assets/**","/css/floating-labels.css","/js/**");
    }
}
