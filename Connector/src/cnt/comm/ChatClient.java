package cnt.comm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import ui.component.IFrame;
import ui.component.IMetaFrame;

/**
 * 서버와의 연결 인터페이스
 * @author kim
 *
 */
@ClientEndpoint
public class ChatClient {
	private Map<String, Session> sessionMap = new HashMap<String, Session>() ;
	private String clientKey;
	private IFrame frmDiag = null;
	private IMetaFrame frmMeta = null;
	
	ChatClient(IFrame frm){
		frmDiag = frm;
	}
	
	ChatClient(IMetaFrame frm){
		frmMeta = frm;
	}
	@OnOpen
	public void onOpen(Session session) {
		
    }
	
	@OnMessage
	public void onMessage(Object Message){
		if(frmMeta == null){
			return;
		}
		// 클라이언트 리스트들을 객체에서 받아 메인화면으로 전달.
		ArrayList<String> strAlive = new ArrayList<String>(); 
		frmMeta.listAliveClient(strAlive);
	}

	@OnMessage
	public void onMessage(String message){
		if(frmDiag == null){
			return;
		}
		// 텍스트를 대화창 화면으로 전달.
		frmDiag.setText(message);
	}
	
}
