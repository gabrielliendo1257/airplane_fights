package com.gcorp.service.app.itineraryservice.app.response;

public record ApiResponse<T> (
        Boolean success,
        T data,
        ApiError error
)
{}
