package com.gcorp.service.app.authorizationservice.presenter.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "${authorization.env.api.path-base}",
        consumes = MediaType.TEXT_PLAIN_VALUE,
        produces = MediaType.TEXT_PLAIN_VALUE
)
public class HelloController
{
    @GetMapping(value = "/hello")
    public String hello()
    {
        return "Hello World";
    }
}
