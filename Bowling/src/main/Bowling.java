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

public class Bowling {
	
	private Player[] players = new Player[Main.PLAYER_NUM];
	private int turn;
	private int frame;
	
	GameBoard gameBoard = new GameBoard();
	
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
				int level = Integer.parseInt(scanner.nextLine());
				
				if (level == 0) {
					System.out.println("프로그램을 종료합니다.");
					return;
				} else if (level > 3) {
					System.out.println("범위가 잘못됐습니다.");
					continue;
				}
				
				// 플레이어 생성
				players[playerId - 1] = new Player(level);
				
				if (playerId == Main.PLAYER_NUM) {
					break;
				}
				
				playerId++;
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다.");
				scanner.nextLine();
			}
		} // 플레이어 설정 완료
		
		turn = 0;
		frame = 1;
		
		// 게임 시작
		while (true) {
			// 점수판 출력
			gameBoard.show();
			
			// 플레이어 턴 확인
			System.out.println("플레이어" + (turn+1) + " 차례");
			Player curPlayer = players[turn];
			
			// 볼링핀 상태 출력
			Pins pins = new Pins();
			pins.show();
			int remainPinNum = pins.getRemainNum();
			
			if (frame == 10) {
				// 10프레임의 1차 시도
				System.out.println("1차 시도 ");
				System.out.print("Press Any Key...");
				scanner.nextLine();
				int droppedPinNum = curPlayer.throwBall(remainPinNum);
				remainPinNum -= droppedPinNum;
				pins.drop(droppedPinNum);
				
				// 점수판에 기록
				gameBoard.writeHistory(droppedPinNum, turn, frame, 1);
				gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
				
				if (remainPinNum == 0) { // 1차 시도 스트라이크친 경우
					// 점수판 출력
					gameBoard.show();
					
					// 플레이어 턴 확인
					System.out.println("플레이어" + (turn+1) + " 차례");
					
					// 볼링핀 상태 출력
					pins = new Pins();
					pins.show();
					remainPinNum = pins.getRemainNum();
					
					// 10프레임의 2차 시도
					System.out.println("2차 시도 ");
					System.out.print("Press Any Key...");
					scanner.nextLine();
					droppedPinNum = curPlayer.throwBall(remainPinNum);
					remainPinNum -= droppedPinNum;
					pins.drop(droppedPinNum);
					
					// 점수판에 기록
					gameBoard.writeHistory(droppedPinNum, turn, frame, 2);
					gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					
					if (remainPinNum == 0) { // 2차 시도 스트라이크친 경우
						// 점수판 출력
						gameBoard.show();
						
						// 플레이어 턴 확인
						System.out.println("플레이어" + (turn+1) + " 차례");
						
						// 볼링핀 상태 출력
						pins = new Pins();
						pins.show();
						remainPinNum = pins.getRemainNum();
						
						// 10프레임의 3차 시도
						System.out.println("3차 시도 ");
						System.out.print("Press Any Key...");
						scanner.nextLine();
						droppedPinNum = curPlayer.throwBall(remainPinNum);
						remainPinNum -= droppedPinNum;
						pins.drop(droppedPinNum);
						
						// 점수판에 기록
						gameBoard.writeHistory(droppedPinNum, turn, frame, 3);
						gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					} else { // 2차 시도 스크라이크 못친 경우
						// 점수판 출력
						gameBoard.show();
						
						// 플레이어 턴 확인
						System.out.println("플레이어" + (turn+1) + " 차례");

						// 볼링핀 상태 출력
						pins.show();
						remainPinNum = pins.getRemainNum();
						
						// 10프레임의 3차 시도
						System.out.println("3차 시도 ");
						System.out.print("Press Any Key...");
						scanner.nextLine();
						droppedPinNum = curPlayer.throwBall(remainPinNum);
						remainPinNum -= droppedPinNum;
						pins.drop(droppedPinNum);
						
						// 점수판에 기록
						gameBoard.writeHistory(droppedPinNum, turn, frame, 3);
						gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					}
				} else { // 1차 시도 스트라이크 못 친 경우
					// 점수판 출력
					gameBoard.show();
					
					// 플레이어 턴 확인
					System.out.println("플레이어" + (turn+1) + " 차례");

					// 볼링핀 상태 출력
					pins.show();
					remainPinNum = pins.getRemainNum();
					
					// 10프레임의 2차 시도
					System.out.println("2차 시도 ");
					System.out.print("Press Any Key...");
					scanner.nextLine();
					droppedPinNum = curPlayer.throwBall(remainPinNum);
					remainPinNum -= droppedPinNum;
					pins.drop(droppedPinNum);
					
					// 점수판에 기록
					gameBoard.writeHistory(droppedPinNum, turn, frame, 2);
					gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					
					if (remainPinNum == 0) { // 2차 시도 스페어 처리한 경우
						// 점수판 출력
						gameBoard.show();
						
						// 플레이어 턴 확인
						System.out.println("플레이어" + (turn+1) + " 차례");
						
						// 볼링핀 상태 출력
						pins = new Pins();
						pins.show();
						remainPinNum = pins.getRemainNum();
						
						// 10프레임의 3차 시도
						System.out.println("3차 시도 ");
						System.out.print("Press Any Key...");
						scanner.nextLine();
						droppedPinNum = curPlayer.throwBall(remainPinNum);
						remainPinNum -= droppedPinNum;
						pins.drop(droppedPinNum);
						
						// 점수판에 기록
						gameBoard.writeHistory(droppedPinNum, turn, frame, 3);
						gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					}
				}
			} else { // 10프레임이 아닐때
				// 볼링공 던지기: 1차 시도
				System.out.println("1차 시도 ");
				System.out.print("Press Any Key...");
				scanner.nextLine();
				int droppedPinNum = curPlayer.throwBall(remainPinNum);
				remainPinNum -= droppedPinNum;
				pins.drop(droppedPinNum);
				
				// 점수판에 기록
				gameBoard.writeHistory(droppedPinNum, turn, frame, 1);
				
				// 스트라이크를 쳤을 때
				if (remainPinNum == 0) {
					gameBoard.writeFrameScore(droppedPinNum, 2, turn, frame);
				} else { // 스트라이크를 치지 못했을 때
					gameBoard.writeFrameScore(droppedPinNum, -1, turn, frame);
					// 점수판 출력
					gameBoard.show();
					System.out.println("플레이어" + (turn+1) + " 차례");
					// 볼링핀 상태 출력
					pins.show();
					// 2차 시도
					System.out.println("2차시도 ");
					System.out.print("Press Any Key...");
					scanner.nextLine();
					// 던지기
					droppedPinNum = curPlayer.throwBall(remainPinNum);
					remainPinNum -= droppedPinNum;
					gameBoard.writeHistory(droppedPinNum, turn, frame, 2);
					
					// 스페어 성공
					if (remainPinNum == 0) {
						gameBoard.writeFrameScore(droppedPinNum, 1, turn, frame);
					} else { // 스페어 실패
						gameBoard.writeFrameScore(droppedPinNum, 0, turn, frame);
					}
				}
			}
			
			// 턴 넘기기
			if (turn == Main.PLAYER_NUM - 1) {
				turn = 0;
				frame++;
			}
			
			else
				turn++;
			
			// 게임 종료
			if (frame > 10) {
				gameBoard.show();
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
	}
}
