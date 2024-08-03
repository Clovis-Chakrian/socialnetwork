package com.clovischakrian.socialnetwork.libs.mediatr;

public interface IRequestHandler<T extends IRequest<U>, U> {
    public U handle(T request);
}
