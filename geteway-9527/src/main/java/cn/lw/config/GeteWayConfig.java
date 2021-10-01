package cn.lw.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author linwei
 * @Date 2021/10/1 11:29
 * @Description 代码方式配置路由
 */
@Configuration
public class GeteWayConfig {
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("provider-payment",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"));

        routes.route("provider-payment",
                r -> r.path("/mil")
                        .uri("http://news.baidu.com/mil"));

        return routes.build();

    }
}