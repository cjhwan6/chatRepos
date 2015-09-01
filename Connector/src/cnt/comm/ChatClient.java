package cnt.comm;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import ui.component.IFrame;
import ui.component.IMetaFrame;

/**
 * 서버와의 연결 인터페이스
 * @author kim
 *
 */
@ClientEndpoint
public class ChatClient extends Endpoint {
	private Session session = null;
	private String clientKey = "";
	private IFrame frmDiag = null;
	private IMetaFrame frmMeta = null;
	
	public ChatClient(IFrame frm, String connUri){
		frmDiag = frm;		
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(this, new URI(connUri));
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ChatClient(IMetaFrame frm, String connUri){
		frmMeta = frm;		
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			container.connectToServer(this, new URI(connUri));
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onOpen(Session sess, EndpointConfig ec) {
		// TODO Auto-generated method stub
		this.session = sess;
	}

	@OnMessage
	public void onMessage(Object message){
		if(frmMeta == null){
			// 이 EndPoint가 대화창과 연결된 경우
			// 텍스트를 대화창 화면으로 전달.
			frmDiag.setText(String.valueOf(message));
		}
		else if(frmDiag == null){
			// 이 EndPoint가 메인창 연결된 경우
			// 연결 리스트들을 뿌려줌
			frmMeta.listAliveClient((ArrayList<String>)message);;
		}

	}
	
}
