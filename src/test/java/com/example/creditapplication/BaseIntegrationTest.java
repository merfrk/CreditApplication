package com.example.creditapplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {

//    protected String BEARER_TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNjQ0Nzk0ODI3LCJleHAiOjIyNDk1OTQ4Mjd9._kBi0Bww8wl0uRS0Tk_2tZB40THfc2oAiamkiFeo3_DTwiBqm1LtzAp8ZpYA15gw9EcTMHUFRZFWGyoRb6BYqA";

    @LocalServerPort
    protected int serverPort;

    @Autowired
    protected TestRestTemplate testRestTemplate;


    @Test
    void contextLoads() {
    }

}
