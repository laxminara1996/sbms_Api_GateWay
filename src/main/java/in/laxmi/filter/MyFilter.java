package in.laxmi.filter;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;
@Component
public class MyFilter implements GlobalFilter  {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("filter executed..........");
		ServerHttpRequest request = exchange.getRequest();//capture complete request from browser
		HttpHeaders headers = request.getHeaders();
		Set<String> keySet = headers.keySet();
			for(String key : keySet) {
				System.out.print(key+"------");
				System.out.println(headers.getValuesAsList(key));
			
		}
		return chain.filter(exchange);
	}

}
