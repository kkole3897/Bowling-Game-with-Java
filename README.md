# 볼링 게임

중앙대 소프트웨어 학부 2020년 1학기 소프트웨어 프로젝트 텀 프로젝트로 자바를 이용해 볼링 게임을 제작

## 주요 규칙

### 점수판
<img src="https://mblogthumb-phinf.pstatic.net/20130630_30/lifesewon_1372584267266CBgk9_JPEG/%BA%BC%B8%B5%C1%A1%BC%F6_%282%29.jpg?type=w2">

### 용어 설명

- 프레임: 한 프레임당 2번의 기회가 주어지고 첫번째 시도에서 모든 핀을 쓰러뜨릴 경우 다음 프레임으로 넘어간다.
- 스트라이크: 한 프레임의 첫번째 시도에 모든 핀을 쓰러뜨리는 것을 뜻한다. 점수판에 `X`로 표시된다.
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
- 스페어: 한 프레임의 두번째 시도에 첫번째 시도에서 쓰러뜨리지 못한 나머지 핀을 모두 쓰러뜨리는 것을 뜻한다. 점수판에 `/`로 표시된다.
- 거터: 핀이 하나도 맞지 않은 경우로 점수판에 `-`로 표시된다.
- 오픈: 한 프레임에 10개의 핀을 모두 쓰러뜨리지 못한 경우를 뜻한다.


### 점수 계산

- 10개의 핀을 12프레임 동안 쳐서 얻어진 점수를 계산
- 기본적으로 쓰러뜨린 핀의 개수가 점수가 된다.
- 거터: 0점 처리된다.
- 오픈: 초구와 2구 때 쓰러뜨린 핀의 합이 점수가 된다.
- 스페어: 다음 프레임의 초구에 쓰러뜨린 핀만큼 스페어 처리한 프레임에 보너스 점수를 얻을 수 있다.
  - 1프레임에서 스페어 처리를 하고 2프레임의 1구에 8개의 핀을 쓰러뜨린 경우 1프레임 10점에 보너스 점수 8점을 획득하여 1프레임의 점수는 10 + 8 = 18점이 된다. 만약 2프레임에 스트라이크를 쳤다면 10 + 10 = 20점을 1프레임에 얻게 되는 것이다.
- 스트라이크: 스트라이크를 친 경우 다음 프레임의 2구까지 보너스 점수에 반영된다.
  - 1프레임에 스트라이크를 치고 2프레임의 1구에는 7개, 2구에는 2개의 핀을 쓰러뜨린 경우에는 1프레임의 10점과 보너스점수 9점을 획득하여 1프레임의 점수는 10 + 9 = 19점이 된다.
  - 만약 1프레임에 스트라이크 2프레임에 스트라이크를 쳤다면 1프레임의 보너스 점수는 3프레임의 초구까지 반영된다.
- 10프레임의 경우는 이전 프레임과 방식이 조금 다르다. 10프레임은 총 3번의 기회가 주어지는데 3번째 기회는 초구에 스트라이크를 쳤거나 2구 때 스페어 처리를 한 경우에만 주어진다.
- 10프레임의 3번째 기회에는 보너스 점수가 존재하지 않고, 쓰러뜨린 핀의 수가 점수에 바로 적용된다.
  
