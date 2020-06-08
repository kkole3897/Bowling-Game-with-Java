/*
 * 작성자 : 김진관
 * 마지막 작성일 : 2020-06-08
 * 개요 : 볼링 게임
 *      2명의 플레이어가 10프레임동안 번갈아가며 게임을 진행하고 과정과 결과를 보여주는 프로그램
 *      쓰러뜨리는 볼링핀의 개수는 등급에 따라 달라진다.
 * 버전
 * 	- v0.1 : 시작. 플레이어 설정 완료
 */

package main;

import java.util.*;

public class Bowling {
	
	private Player[] players = new Player[2];
	
	public Bowling() {
		System.out.println("볼링 게임을 시작합니다.");
		
		// 플레이어 설정
		Scanner scanner = new Scanner(System.in);
		
		int playerId = 1;
		while (true) {
			System.out.println("플레이어" + playerId + "의 등급을 정해주세요.");
			System.out.println("0.종료  | 1.초급  | 2.중급  | 3.고급");
			
			try {
				System.out.print(">> ");
				int level = scanner.nextInt();
				
				if (level == 0) {
					System.out.println("프로그램을 종료합니다.");
					return;
				} else if (level > 3) {
					System.out.println("범위가 잘못됐습니다.");
					continue;
				}
				
				// 플레이어 생성
				players[playerId - 1] = new Player(level);
				
				if (playerId == 2) {
					break;
				}
				
				playerId++;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				scanner.nextLine();
			}
		} // 플레이어 설정
		
		// 설정 확인
		for (int i = 0; i < 2; i++) {
			System.out.println("플레이어" + (i+1) + " " + players[i].getLevel());
		}
		
		// 게임 시작
		
	}
}
