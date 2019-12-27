# SpringBoot

> 1. https://spring.io/tools
>
> 2. 다운로드폴더->파일->파워쉘열기 (압출풀기)
>
>    ->java -jar sp [tab]키 //안되면 java 환경변수가 지정안되있는 것 (환경변수 설정 or 밑에 결로 입력)
>
>    ->C:\Program Files\ojdkbuild\java-1.8.0-openjdk-1.8.0.232-1\bin\java 입력
>
> 3. SpringToolsuite4 -->dev에 설치
>
> 4. https://projectlombok.org/all-versions (1.18.10)
>
> 5. Lombok : 클래스에서 각 멤버변수를 접근할수 있는 (각 요소들이 private 접근권한을 가지고 있을때) method 를 만들게 된다. 이 것을 자동으로 만들어준다.
>
> 6. java -jar lom[tab]->springboot.exe파일 등록 (C:\dev\sts-4.5.0.RELEASE 안에 springtoolsuite4)
>
> 7. create new spring starter project
>
> 8. name:basic type: gradle(3.x) group: 주소명 거꾸로 com.daehyeon package: com.daehyeon.basic
>
> 9. Lombok / Spring Data JPA / H2 Database / Thymeleaf / Spring Web (5개) 추가
>
>    - database 지식이 없기 때문에 경량화 데이터베이스 H2,jpa사용
>
>    - HTML , CSS 를 쉽게 Thymeleaf 사용
>
>    - lombok 편하게 하기위해
>
>    - web을 만들기 위해 spring web
>
>      ---> pip같이 처음에 다 다운로드하는 것이 아닌 필요할 때 입력해서 다운로드
>
>     --> 이러한 기술 : java에선 grdlew , maven
>
> 10. ctrl+f11 : 런(실행) : 3번 런 시키면 3개 실행 --> 할 때마다 정지시켜야한다.
>
> 11. 오류뜨면 : gradlew -> refresh
>
> 12. 

### Build Tool

- 늘어나는 라이브러리 자동 추가, 동기, 관리 ( maven, gradle )
- gradle(Build Tool) : 프로젝트를 진행하면서 많은 라이브러리를 직접사이트에서 다운로드 받아 추가하지 않고 쉽게 다운로드, 동기화하며 라이브러리를 관리해주는 도구
- build.gradle -> 라이브러리 다 들어 있음

STS 인코딩 설정 변경

- Window -> preference -> encoding 검색 ->workspace ->content type을 제외한 utf-8설정

### Loger

> // 시스템아웃프린트에프의 내용을 파일에 저장 // system.out보다 속도가 빠르다. (출력속도가 빠르다.) // log 관리가 쉽다. (파일등을 이용하여 관리가 용이함.).

//info 까지만 나오는 것을 trace까지 찍게해준다.

dev-tools

SpringBoot DevTools

- 서버 재기동없이 수정사항 적용(추가함으로써 런 종료 런 종료 할 필요없이 저장으로 동기화가능)
- implementation "org.springframework.boot:spring-boot-devtools"

### 응답처리

> 서버가 제공하는 응답(보여줄 수 있는 정보)가 HTML,JSON,EXCEL,PDF 여러가지 자료가 있다.
>
> String / void / Map / Model / ModelAndView / DTO으로 정보를 요청하면 HTML로 정보를 준다.
>
> Map/DTO/List로 요청하면 JSO으로 응답을 준다.