/*
 * 작성자 : 김진관
 * 마지막 작성일 : 2020-06-12
 * 개요 : 볼링 게임
 *      2명의 플레이어가 10프레임동안 번갈아가며 게임을 진행하고 과정과 결과를 보여주는 프로그램
 *      쓰러뜨리는 볼링핀의 개수는 등급에 따라 달라진다.
 * 버전
 * 	- v0.1 : 시작. 플레이어 설정 완료
 *  - v0.2 : 점수판 출력 방식, 볼링핀 출력 양식 설정, 넘어뜨린 핀 개수 기록
 *  - v0.3 : 10프레임까지 점수 계산 및 점수판 출력 완료
 *  - v0.4 : 플레이어 등급별로 실력 차등 구현, 인터페이스 개선
 */

package main;

import java.util.*;

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
	
	public int throwBall(int remainPinNum) {
		Random random = new Random();
		
		int droppedPins = 0;
		
		if (level == BEGINNER) {
			droppedPins = (int)(random.nextGaussian() * 5 + 5);
		} else if (level == INTERMEDIATE) {
			droppedPins = (int)(random.nextGaussian() * 3 + 7);
		} else if (level == ADVANCED) {
			droppedPins = (int)(random.nextGaussian() * 2 + 9);
		}
		
		droppedPins = (droppedPins > remainPinNum) ? remainPinNum : droppedPins;
		droppedPins = (droppedPins < 0) ? 0: droppedPins;
		
		return droppedPins;
	}
}
