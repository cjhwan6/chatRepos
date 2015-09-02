package com.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/ChatMess")
public class ChatEndPoint  {
	
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void onOpen(Session s, EndpointConfig e) {
		peers.add(s);
	}
	
	@OnClose
	public void onClose(Session s){		
		peers.remove(s);
	}
		
	/**
	 * 대화상대 조회시 사용
	 * @param message
	 * @param clientId
	 */
	@OnMessage
	public void onMessage(String message,String clientId){
		ArrayList<String> rtnClient = new ArrayList<String>();
		Session tarClient = null;
//		for(String key : clientMap.keySet() ){
//			LinkedList<Session> lstClient = clientMap.get(key);
//			// 객체 메세지 수신시, 접속된 Client들 정보를 모두 반환함.
//			for(Session client : lstClient){
//				String strName = String.valueOf(client.getUserProperties().get("clientName"));
//				rtnClient.add(strName);
//				if(strName.equals(clientId)){
//					tarClient = client;
//				}
//			}			
//		}		
//		if(tarClient == null){
//			return;
//		}
//		// 요청대상에 반환
//		try {
//			tarClient.getBasicRemote().sendObject(rtnClient);
//		} catch (IOException | EncodeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
	@OnError
	public void onError(Throwable error){
		
	}
}
