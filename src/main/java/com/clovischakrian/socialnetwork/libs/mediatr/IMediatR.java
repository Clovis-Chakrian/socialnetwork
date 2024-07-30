package com.clovischakrian.socialnetwork.libs.mediatr;

import java.lang.reflect.InvocationTargetException;

public interface IMediatR {
    public<T extends IRequest> Object send(T message) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, Exception;
}
