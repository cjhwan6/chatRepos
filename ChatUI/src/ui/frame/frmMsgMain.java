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
	// �׸���(��� ����) -> ��ȭ ��� ǥ�ÿ�
	private JTable counterparty;
	// �׸���(��� ����) -> ��ȭ ��� ǥ�ÿ�
	private JScrollPane counterpartyPane;
	// EditorPane(�̸� ��������)
	private JEditorPane name;
	// Properties
	private Properties config;	

	/**
	 * ȭ�� �ʱ�ȭ �޼ҵ�
	 */
	public void init(){
		String usrName = "";
		// â ����
		setLayout(null);
		setLocation(200,200);
		setSize(250,400);
		config = readProp();
		usrName = getUserName(config);
		setTitle(usrName + "�� ȯ���մϴ�.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		// ��ȭ ��� ǥ�ÿ� �׸��� ���� & �߰�
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
		
		// �̸� ������ EditorPane ���� & �߰�
		// �ڵ� ���� ����
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
		// Properties�� �̸� ��������
		File prop = new File("config.properties");		
		if(!prop.exists()){
			// ������ ������ ����.(name=��ǻ���̸�)
			String pcName = getLocalName();
			String defaultSvr = "";
			
			rtnProp.setProperty("name", pcName);
			// ���� ��� �ڵ� ����
			rtnProp.setProperty("serverEndpoint", defaultSvr);
			writeFile(prop,rtnProp);
		}
		else{
			// �̸� �о����
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
	 * �����б�
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
	 * ���Ͼ���
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
	 * ������ ���ӵ� Ŭ���̾�Ʈ ����� ������(��ȭ��� ���)
	 */
	@Override
	public void listAliveClient(ArrayList<String> lstAliveClient) {
		
	}
	
	/**
	 * ���� ����
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
