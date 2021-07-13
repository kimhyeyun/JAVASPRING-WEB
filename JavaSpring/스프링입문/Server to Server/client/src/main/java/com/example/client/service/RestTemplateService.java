package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class RestTemplateService {

    // http://localhost:9090/api/server/hello 요청해서
    // response 받아옴

    public UserResponse hello(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "aaa")
                .queryParam("age", 99)
                .encode()
                .build()
                .toUri();

        log.info("uri : {}", uri.toString());

        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri,UserResponse.class);


        log.info("status code : {}", result.getStatusCode());
        log.info("body : {}", result.getBody());

        return result.getBody();
    }

    public void post(){
        // http://localhost:9090/api/server/user/{userId}/name/{userName}

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();

        log.info("uri : {}", uri.toString());

        // http body -> object -> object mapper -> json -> rest template -> http body json

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, req, String.class);

        log.info("status code : {}", responseEntity.getStatusCode());
        log.info("header : {}", responseEntity.getHeaders());
        log.info("body : {}", responseEntity.getBody());

//        return responseEntity.getBody();
    }

    public UserResponse exchange(){
        // http://localhost:9090/api/server/user/{userId}/name/{userName}

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();

        log.info("uri : {}", uri.toString());

        // http body -> object -> object mapper -> json -> rest template -> http body json

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);

        RequestEntity<UserRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header","fffff")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);

        return response.getBody();
    }

    public Req<UserResponse> genericExchange(){
        // http://localhost:9090/api/server/user/{userId}/name/{userName}

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "steve")
                .toUri();

        log.info("uri : {}", uri.toString());

        // http body -> object -> object mapper -> json -> rest template -> http body json

        UserRequest request = new UserRequest();
        request.setName("steve");
        request.setAge(10);

        Req req = new Req<UserRequest>();
        req.setHeader(new Req.Header());
        req.setResBody(request);

        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header","fffff")
                .body(req);

        
        RestTemplate restTemplate = new RestTemplate();
//        new ParameterizedTypeReference<Req<UserResponse>>(){}; -> generic 은 .class 사용안되서 대신 !
        ResponseEntity<Req<UserResponse>> reqResponseEntity
                = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>(){});

        return reqResponseEntity.getBody();
    }

}
