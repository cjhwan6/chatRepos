package ui.component;

/**
 * ��ȭ�� ȭ�� ������ �����ϴ� �������̽�
 * @author kim
 *
 */
public interface IFrame {
	/**
	 * ȭ�� �ʱ�ȭ
	 */
	public void init();
	
	/**
	 * ��ȭ�� ���� Ű ���ϱ�
	 * @return
	 */
	public String getKey();
	
	/**
	 * ��ȭ�� ���� Ű ����
	 * @param key
	 */
	public void setKey(String key);

	/**
	 * ��ȭ�� ���� ���ڿ� ����
	 * @param message
	 */
	public void setText(String message);
}
