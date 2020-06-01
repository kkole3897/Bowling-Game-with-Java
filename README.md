# 볼링 게임

중앙대 소프트웨어 학부 2020년 1학기 소프트웨어 프로젝트 텀 프로젝트로 자바를 이용해 볼링 게임을 제작

## 주요 규칙

### 용어 설명

- 프레임: 한 프레임당 2번의 기회가 주어지고 첫번째 시도에서 모든 핀을 쓰러뜨릴 경우 다음 프레임으로 넘어간다.
- 스트라이크: 한 프레임의 첫번째 시도에 모든 핀을 쓰러뜨리는 것을 뜻한다.
  - 연속된 스트라이크마다 용어가 다르다.
  
  |연속 스트라이크 개수|명칭|
  |:-----:|:--------------------:|
  |1개|스트라이크|
  |2개|더블|
  |3개|터키|
  |4개|포 베가|
  |5개|파이브 베가|
  |6개|식스 베가|
  |7개|세븐 인 어 로우|
  |8개|에잇 컨섹큐티브 스트라이크|
  |9개|나인 컨섹큐티브 스트라이크|
  |10개|텐 컨섹큐티브 스트라이크|
  |11개|일레븐 컨섹큐티브 스트라이크|
  |12개|퍼펙트 게임|
- 스페어: 한 프레임의 두번째 시도에 첫번째 시도에서 쓰러뜨리지 못한 나머지 핀을 모두 쓰러뜨리는 것을 뜻한다.

### 점수 계산

- 10개의 핀을 12프레임 동안 쳐서 얻어진 점수를 계산
- 기본적으로 쓰러뜨린 핀의 개수가 점수가 된다.
- 거터: 핀이 하나도 맞지 않은 경우로 점수판에 __'-'__로 표시되고 0점 처리된다.
- 오픈: 한 프레임에 10개의 핀을 모두 쓰러뜨리지 못한 경우를 뜻한다. 초구와 2구 때 쓰러뜨린 핀의 합이 
점수가 된다.
- 스페어: 커버라고도 불리며 다음 프레임의 초구에 쓰러뜨린 핀만큼 스페어 처리한 프레임에 보너스 점수를 
얻을 수 있다. 점수판의 **\/**로 표시된다.
  - 1프레임에서 스페어 처리를 하고 2프레임의 1구에 8개의 핀을 쓰러뜨린 경우 1프레임 10점에 보너스 점수 8점을 획득하여 1프레임의 점수는 10 + 8 = 18점이 된다. 만약 2프레임에 스트라이크를 쳤다면 10 + 10 = 20점을 1프레임에 얻게 되는 것이다.
