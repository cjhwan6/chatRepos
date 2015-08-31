package ui.frame;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

import ui.component.IFrame;

public class frmMsgDialog extends JFrame implements IFrame{
	// 텍스트 상자(대화내용)
	private JEditorPane dialog; 
	// 텍스트 상자(입력부)
	private JEditorPane input;
	// 텍스트 상자(디버깅용)
	private JEditorPane debug;
	// 전송 버튼	
	private JButton btnSend;
		
	private String diagKey;
	/**
	 * 화면 초기화 메소드
	 */
	public void init(){
		setLayout(null);
		// 대화 내용 텍스트상자 설정 & 추가
		// 입력부 텍스트상자 설정 & 추가
		// 디버깅용 텍스트상자 설정 & 추가
		// 전송버튼 설정 & 추가
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
