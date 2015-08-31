package ui.component;

/**
 * 대화방 화면 동작을 정의하는 인터페이스
 * @author kim
 *
 */
public interface IFrame {
	/**
	 * 화면 초기화
	 */
	public void init();
	
	/**
	 * 대화방 내부 키 구하기
	 * @return
	 */
	public String getKey();
	
	/**
	 * 대화방 내부 키 셋팅
	 * @param key
	 */
	public void setKey(String key);

	/**
	 * 대화방 내부 문자열 셋팅
	 * @param message
	 */
	public void setText(String message);
}
