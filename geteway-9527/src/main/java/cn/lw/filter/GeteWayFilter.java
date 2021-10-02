package cn.lw.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author linwei
 * @Date 2021/10/2 13:48
 * @Description TODO
 */
//@Component
//@Slf4j
////自定义过滤器必须实现GlobalFilter、Ordered这两个接口
//public class GeteWayFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("****进入过滤器******");
//        String uname=exchange.getRequest().getQueryParams().getFirst("uname");
//        if(uname==null){
//            log.info("****uname为null*****");
//            return exchange.getResponse().setComplete();
//        }
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}