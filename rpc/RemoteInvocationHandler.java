package com.gupaoedu.rmi.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 腾讯课堂搜索 
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //组装请求
        RpcRequest request=new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        //通过tcp传输协议进行传输
        TCPTransport tcpTransport=new TCPTransport(this.host,this.port);
        //发送请求
        return tcpTransport.send(request);
    }
}
