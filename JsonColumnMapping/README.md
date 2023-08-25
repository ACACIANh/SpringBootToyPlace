### 테스트 목적

1. entity 의 객체를 db 에 longtext type json_valid 를 이용하여 json 형태로 저장하려고 하였음
2. 어떤건 되고 어떤건 안되어 해당 문제를 고치기 위해 테스트 시도하게 되었음

### 문제가 될만한 부분 추측 및 방향성

1. enum type 에 jsonFormat 적용 유무에 따른 차이
2. 필드가 일반 객체 타입은 되었지만 Collection type 은 되지 않아 해당 예제도 재 테스트
3. @Type( JsonType.class ) 을 이용해서 json 으로 변환해주는데 해당객체의 내부에 한번더 객체타입이 있어서 바꿔야한다면 추가로 붙여줘야 되는지 확인

### 테스트 결과.

1. jsonFormat 이 있어도 안되는걸 보아해서 이건 아니라고 판단
2. Collection type 적용되는것 확인
3. 객체 타입 안에 객체타입이 있어도 변환되는것 확인
4. 필드 객체 안에 enum type 이 있을경우 오류 
 * 정정: 필드 객체 안에 enum type 있고 JsonFormat Object 가 있으면 안되고, enum type 이여도 JsonFormat 이 없으면 상수 이름으로 변환 성공