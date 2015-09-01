package com.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/ChatMess")
public class ChatEndPoint extends Endpoint {
	
	private Map<String,LinkedList<Session>> clientMap = new HashMap<String,LinkedList<Session>>();
	
	@OnOpen
	public void onOpen(Session s, EndpointConfig e) {
		String key = String.valueOf(s.getUserProperties().get("diagKey"));
		LinkedList<Session> lstClient = clientMap.get(key);
		lstClient.add(s);
	}
	
	@OnClose
	public void onClose(Session s){
		String key = String.valueOf(s.getUserProperties().get("diagKey"));
		LinkedList<Session> lstClient = clientMap.get(key);
		lstClient.remove(s);
	}
	
	
	/**
	 * �޼��� ������ ���
	 * @param message
	 * @param clientId
	 */
	@OnMessage
	public void handleMessage(String message,Session sess){
		String key = "";
		LinkedList<Session> lstClient = clientMap.get(key);
		// �޼��� ���Ž�, ���õ� Client�鿡�� ��� ����
		for(Session client : lstClient){
			try {
				client.getBasicRemote().sendText(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * ��ȭ��� ��ȸ�� ���
	 * @param message
	 * @param clientId
	 */
	@OnMessage
	public void onMessage(Object message,String clientId){
		ArrayList<String> rtnClient = new ArrayList<String>();
		Session tarClient = null;
		for(String key : clientMap.keySet() ){
			LinkedList<Session> lstClient = clientMap.get(key);
			// ��ü �޼��� ���Ž�, ���ӵ� Client�� ������ ��� ��ȯ��.
			for(Session client : lstClient){
				String strName = String.valueOf(client.getUserProperties().get("clientName"));
				rtnClient.add(strName);
				if(strName.equals(clientId)){
					tarClient = client;
				}
			}			
		}		
		if(tarClient == null){
			return;
		}
		// ��û��� ��ȯ
		try {
			tarClient.getBasicRemote().sendObject(rtnClient);
		} catch (IOException | EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@OnError
	public void onError(Throwable error){
		
	}
}
