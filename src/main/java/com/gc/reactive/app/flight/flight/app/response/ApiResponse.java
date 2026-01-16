package com.gc.reactive.app.flight.flight.app.response;

public record ApiResponse<T> (
        Boolean success,
        T data,
        ApiError error
)
{}
