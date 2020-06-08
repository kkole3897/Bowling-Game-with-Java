/*
 * 작성자 : 김진관
 * 마지막 작성일 : 2020-06-08
 * 개요 : 볼링 게임
 *      2명의 플레이어가 10프레임동안 번갈아가며 게임을 진행하고 과정과 결과를 보여주는 프로그램
 *      쓰러뜨리는 볼링핀의 개수는 등급에 따라 달라진다.
 * 버전
 * 	- v0.1 : 시작. 플레이어 설정 완료.
 */

package main;

public class Player {
	static final int BEGINNER = 1;
	static final int INTERMEDIATE = 2;
	static final int ADVANCED = 3;
	
	private int level;
	
	public Player(int level) {
		this.level = level;
	}
	
	public String getLevel() {
		String strLevel = null;
		
		if (level == BEGINNER) {
			strLevel = "초급";
		} else if (level == INTERMEDIATE) {
			strLevel = "중급";
		} else if (level == ADVANCED) {
			strLevel = "고급";
		}
		
		return strLevel;
	}
}
