/*
 * 작성자 : 김진관
 * 마지막 작성일 : 2020-06-10
 * 개요 : 볼링 게임
 *      2명의 플레이어가 10프레임동안 번갈아가며 게임을 진행하고 과정과 결과를 보여주는 프로그램
 *      쓰러뜨리는 볼링핀의 개수는 등급에 따라 달라진다.
 * 버전
 * 	- v0.1 : 시작. 플레이어 설정 완료
 *  - v0.2 : 점수판 출력 방식, 볼링핀 출력 양식 설정, 넘어뜨린 핀 개수 기록
 *  - v0.3 : 10프레임까지 점수 계산 및 점수판 출력 완료
 */

package main;

public class Main {
	
	public static final int PLAYER_NUM = 2;

	public static void main(String[] args) {
		new Bowling();

	}

}
