package com.gc.reactive.app.flight.flight.domain.models;

import lombok.Data;

@Data
public class AppPageRequest
{
    private final Integer page;
    private final Integer size;

    public AppPageRequest(Integer page, Integer size)
    {
        if (page < 0 || size < 0) {
            throw new IllegalArgumentException("page and size must both be greater than 0");
        }
        this.page = page;
        this.size = size;
    }
}
