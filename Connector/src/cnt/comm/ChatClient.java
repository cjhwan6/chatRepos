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
 * �������� ���� �������̽�
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
			// �� EndPoint�� ��ȭâ�� ����� ���
			// �ؽ�Ʈ�� ��ȭâ ȭ������ ����.
			frmDiag.setText(String.valueOf(message));
		}
		else if(frmDiag == null){
			// �� EndPoint�� ����â ����� ���
			// ���� ����Ʈ���� �ѷ���
			frmMeta.listAliveClient((ArrayList<String>)message);;
		}

	}
	
}
