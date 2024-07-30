package com.clovischakrian.socialnetwork.libs.mediatr;

import com.clovischakrian.socialnetwork.libs.mediatr.exceptions.RequestHandlerNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

@Component
public class MediatR implements IMediatR {
    ApplicationContext context;

    public MediatR(ApplicationContext context) {
        this.context = context;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Object send(IRequest message) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, RequestHandlerNotFoundException {
        IRequestHandler handler = getRequestHandler(message.getClass());
        Method handle = handler.getClass().getDeclaredMethod("handle", IRequest.class);

        System.out.println(handle.invoke(handler, message));

        return handle.invoke(handler, message);
    }

    @SuppressWarnings("rawtypes")
    public IRequestHandler getRequestHandler(Class<?> messageType) throws RequestHandlerNotFoundException {
        Map<String, IRequestHandler> handlers = context.getBeansOfType(IRequestHandler.class);
        for (Map.Entry<String, IRequestHandler> currentHandler : handlers.entrySet()) {
            Class<?> handlerClass = currentHandler.getValue().getClass();
            Type[] interfaces = handlerClass.getGenericInterfaces();

            for (Type requestInterface : interfaces) {
                Type requestInterfaceType = ((ParameterizedType) requestInterface).getActualTypeArguments()[0];
                if (requestInterfaceType.equals(messageType)) {
                    return currentHandler.getValue();
                }
            }
        }

        throw new RequestHandlerNotFoundException("Handler implementation for " + messageType.getTypeName() + " not found. Have you forgot to implement or put @Service annotation?");
    }
}
