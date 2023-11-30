package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }



    public void reallyClose() {

        realConnection.close();
        realConnection.isClosed();

    }

    @Override
    public void close() {

        ConnectionPool.getInstance().releaseConnection(this);
        realConnection.isClosed();
    }

    @Override
    public boolean isClosed() {
    return false;
    }
}
