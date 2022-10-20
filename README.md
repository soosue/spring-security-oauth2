# 스프링 시큐리티 OAuth2.0 연습

- "/", "/loginpage" 에 대해서는 모두 접근 가능하다.
- "/page" 로 시작하는 모든 요청에 대해서는 모두 접근 가능하다.
- "/board" 는 `User` 권한을 가진 사용자만 접근 가능하다.
- "/mypage" 는 로그인한 사람(인증된 사람, authenticated된 사용자)만 접근 가능하다.


- 권한이 맞지 않는 요청의 경우 forbidden.html 페이지를 보여준다. (/board)
- 인증되지 않은 경우 /loginpage 로 리다이렉트 시킨다.
  - 권한을 체크해야하는데, 인증되지 않아 확인 못 하는 경우도 /loginpage 로 간다.


- 스프링 시큐리티는 필터 기반이기 때문에 설정 순서가 중요하다.
  - SecurityConfig 의 설정 순서가 유의미하다.
  
### kakao developers 설정
- application-oauth.yml 의 client-id 에 카카오 로그인의 앱 키 REST API 키를 넣는다.
- 플랫폼 하단 Redirect URI 등록에 http://localhost:8080/login/oauth2/code/kakao 를 넣는다.
