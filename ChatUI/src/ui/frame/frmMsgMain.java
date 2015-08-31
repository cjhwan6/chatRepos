package ui.frame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import ui.component.ClientListModel;
import ui.component.IMetaFrame;

/**
 * 
 * @author kim
 *
 */
public class frmMsgMain extends JFrame implements IMetaFrame{
	// 그리드(헤더 없는) -> 대화 상대 표시용
	private JTable counterparty;
	// 그리드(헤더 없는) -> 대화 상대 표시용
	private JScrollPane counterpartyPane;
	// EditorPane(이름 가져오기)
	private JEditorPane name;
	// Properties
	private Properties config;	

	/**
	 * 화면 초기화 메소드
	 */
	public void init(){
		String usrName = "";
		// 창 설정
		setLayout(null);
		setLocation(200,200);
		setSize(250,400);
		config = readProp();
		usrName = getUserName(config);
		setTitle(usrName + "님 환영합니다.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		// 대화 상대 표시용 그리드 설정 & 추가
		counterparty = new JTable();		
		TableModel dataModel = new ClientListModel();
		
		counterparty.setModel(dataModel);
		counterparty.setLocation(0,0);
		counterparty.setSize(225,300);
		counterpartyPane = new JScrollPane();
		counterpartyPane.setLayout(null);
		counterpartyPane.setLocation (5, 45);
		counterpartyPane.setSize(225, 300);
		counterpartyPane.add(counterparty);
		add(counterpartyPane);
		
		// 이름 편집용 EditorPane 설정 & 추가
		// 자동 서버 접속
		connect();
	}
	
	/**
	 * 
	 * @return
	 */
	private String getUserName(Properties prop){
		String usrName = "";
		usrName = String.valueOf(prop.get("name"));
		return usrName;
	}

	/**
	 * 
	 * @return
	 */
	private Properties readProp(){
		Properties rtnProp = new Properties(); 
		// Properties로 이름 가져오기
		File prop = new File("config.properties");		
		if(!prop.exists()){
			// 파일이 없으면 만듬.(name=컴퓨터이름)
			String pcName = getLocalName();
			String defaultSvr = "";
			
			rtnProp.setProperty("name", pcName);
			// 접속 경로 자동 셋팅
			rtnProp.setProperty("serverEndpoint", defaultSvr);
			writeFile(prop,rtnProp);
		}
		else{
			// 이름 읽어오기
			try {
				rtnProp.load(readFile(prop));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		return rtnProp;
	}
	
	/**
	 * 파일읽기
	 * @param file
	 * @return
	 */
	private FileReader readFile(File file){
		FileReader reader;
		try {
			reader = new FileReader(file);
			return reader;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 파일쓰기
	 * @param file
	 * @return
	 */
	private void writeFile(File file, Properties contents){
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			contents.store(writer, "");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getLocalName() {
		   String pcName = "";
	        try{
	            InetAddress myIP=InetAddress.getLocalHost();
	            pcName = myIP.getHostName();
	      
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	      return pcName;
	}
	
	/**
	 * 서버에 접속된 클라이언트 목록을 가져옴(대화상대 목록)
	 */
	@Override
	public void listAliveClient(ArrayList<String> lstAliveClient) {
		
	}
	
	/**
	 * 서버 접속
	 */
	public void connect(){
		System.out.println("Connected");
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		frmMsgMain main = new frmMsgMain();
		main.init();
		main.setVisible(true);
	}
}
