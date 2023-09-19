참고 - https://www.baeldung.com/java-isinstance-isassignablefrom

# 요약
    instanceof - 실제 인스턴스를 기준으로 타입체크 / prmitive type, clazz 사용시 exception 발생
    isInstance - 실제 인스턴스를 기준으로 타입체크 / instanceof 와 동일 / null 일시 false / 좌항이 동등 혹은 상위 타입이여야한다
    isAssignableFrom - 할당여부까지 체크하여 우항이 좌항에 할당할수 없는 대상이면 false / 비교 대상이 null 일시 exception 발생
