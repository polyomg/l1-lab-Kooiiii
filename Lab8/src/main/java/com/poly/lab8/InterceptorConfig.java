package Lab8.config;

import Lab8.interceptor.AuthInterceptor;
import Lab8.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    AuthInterceptor authInterceptor;

    @Autowired
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns(
                        "/admin/**",
                        "/account/edit-profile",
                        "/account/change-password",
                        "/order/**"
                )
                .excludePathPatterns("/admin/home/index");

        registry.addInterceptor(logInterceptor)
                .addPathPatterns(
                        "/admin/**",
                        "/account/edit-profile",
                        "/account/change-password",
                        "/order/**"
                )
                .excludePathPatterns("/admin/home/index");
    }
}
