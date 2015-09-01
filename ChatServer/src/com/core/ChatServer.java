package com.core;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.Extension;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.websocket.server.ServerEndpointConfig;

public class ChatServer implements WebSocketContainer, Runnable {
	
	private Map<String,ArrayList<Session>> sessMap = new HashMap<String,ArrayList<Session>>();
	
	@Override
	public Session connectToServer(Object arg0, URI arg1) throws DeploymentException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Session connectToServer(Class<?> arg0, URI arg1) throws DeploymentException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Session connectToServer(Endpoint arg0, ClientEndpointConfig arg1, URI arg2)
			throws DeploymentException, IOException {
		// TODO Auto-generated method stub		
		return null;
	}


	@Override
	public Session connectToServer(Class<? extends Endpoint> arg0, ClientEndpointConfig arg1, URI arg2)
			throws DeploymentException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long getDefaultAsyncSendTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getDefaultMaxBinaryMessageBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public long getDefaultMaxSessionIdleTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getDefaultMaxTextMessageBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Set<Extension> getInstalledExtensions() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setAsyncSendTimeout(long arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setDefaultMaxBinaryMessageBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setDefaultMaxSessionIdleTimeout(long arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setDefaultMaxTextMessageBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		Runnable c_instance = new ChatServer();
		while(true){
			c_instance.run();
		}
	}
}
