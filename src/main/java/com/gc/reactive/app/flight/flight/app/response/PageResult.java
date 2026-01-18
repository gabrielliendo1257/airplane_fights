package com.gc.reactive.app.flight.flight.app.response;

import java.util.List;

public record PageResult<T>(
        List<T> items,
        Long totalItems,
        Integer page,
        Integer size
) {}
