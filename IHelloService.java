package com.gupaoedu.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 腾讯课堂搜索 quit edit
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public interface IHelloService extends Remote {

    String sayHello(String msg) throws RemoteException;
}
