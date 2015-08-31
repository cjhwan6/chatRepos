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
 * �������� ���� �������̽�
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
		// Ŭ���̾�Ʈ ����Ʈ���� ��ü���� �޾� ����ȭ������ ����.
		ArrayList<String> strAlive = new ArrayList<String>(); 
		frmMeta.listAliveClient(strAlive);
	}

	@OnMessage
	public void onMessage(String message){
		if(frmDiag == null){
			return;
		}
		// �ؽ�Ʈ�� ��ȭâ ȭ������ ����.
		frmDiag.setText(message);
	}
	
}
