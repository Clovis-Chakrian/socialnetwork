package com.clovischakrian.socialnetwork.libs.mediatr;

import java.lang.reflect.InvocationTargetException;

public interface IMediatR {
    public<T extends IRequest<U>, U> U send(T message) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, Exception;
}
