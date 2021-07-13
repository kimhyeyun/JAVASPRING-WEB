package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 같은 프로젝트의 Filter에서 해주면 여기서도 적용됨
        // 이유 : filter에서 interceptor로 request와 response를 넘겨주기 때문
        // (ContentCachingRequestWrapper)request;

        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url : {}", url);

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}",hasAnnotation);

        // 나의 서버는 모두 PUBLIC으로 동작을 하는데
        // 단! Auth 권한을 가진 ㅇ청에 대해서는 세션, 쿠키,
        if(hasAnnotation){
            // 권한 체크
            String query = uri.getQuery();
            if(query.equals("name=steve"))
                return true;

            throw new AuthException();
        }

        // true 가 되어야 interceptor를 넘어서 내부 logic을 탈수 있음
       return true;
    }

    public boolean checkAnnotation(Object handler, Class clazz){

        // resource javascript, html, 등은 통과!
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        // annotation이 달려있는가?
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)){
            // Auth annotation 이 있을 때는 true
            return true;
        }

        return  false;
    }
}
