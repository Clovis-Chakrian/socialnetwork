package com.clovischakrian.socialnetwork.libs.mediatr;

public interface IRequestHandler<T extends IRequest, U> {
    public U handle(T request);
}
