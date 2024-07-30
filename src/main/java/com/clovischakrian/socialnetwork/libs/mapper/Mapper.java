package com.clovischakrian.socialnetwork.libs.mapper;


public interface Mapper {
    public <T, U> U map(T source, Class<U> destination);
}
