package ui.frame;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

import ui.component.IFrame;

public class frmMsgDialog extends JFrame implements IFrame{
	// �ؽ�Ʈ ����(��ȭ����)
	private JEditorPane dialog; 
	// �ؽ�Ʈ ����(�Էº�)
	private JEditorPane input;
	// �ؽ�Ʈ ����(������)
	private JEditorPane debug;
	// ���� ��ư	
	private JButton btnSend;
		
	private String diagKey;
	/**
	 * ȭ�� �ʱ�ȭ �޼ҵ�
	 */
	public void init(){
		setLayout(null);
		// ��ȭ ���� �ؽ�Ʈ���� ���� & �߰�
		// �Էº� �ؽ�Ʈ���� ���� & �߰�
		// ������ �ؽ�Ʈ���� ���� & �߰�
		// ���۹�ư ���� & �߰�
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return diagKey;
	}

	@Override
	public void setKey(String key) {
		// TODO Auto-generated method stub
		diagKey = key;
	}

	@Override
	public void setText(String message) {
		// TODO Auto-generated method stub
		dialog.setText(message);
	}	
}
