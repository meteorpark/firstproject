## 3장 게시판 만들고 새 글 작성하기: Create

3.4 DB 데이터 조회하기

## 4장 롬복과 리팩터링

4.1 롬복이란

4.2 롬복을 활용해 리팩터링하기

---

### H2

localhost:8080/h2-console 에 접속 후 인텔리제이의 Run탭에 jdbc로그를 찾아 JDBC URL에 넣어준다.

```
-- 찾기: Database available at

2024-03-10T23:10:22.142+09:00 INFO 32058 --- [main] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '
/h2-console'. Database available at 'jdbc:h2:mem:XXXX'
```

### lombok

lombok은 코드를 간소화하고, 반복되는 코드를 줄여주는 라이브러리이다.

getter(), setter(), constructor(), toString() 등의 메서드를 자동으로 생성해주어 코드의 가독성을 높여준다.