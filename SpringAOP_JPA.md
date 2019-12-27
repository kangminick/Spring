> ## 메소드
>
> 1. @RestController
>    - Client의 요청으로부터 View를 반환합니다.
>    - @RestController는 객체를 반환할때 객체 데이터는 바로 JSON/XML 타입의 HTTP 응답을 직접 리턴
>    - html은 불러오지 못함
> 2. @Controller
>    - templates에서 html을 불러와서 실행
>    - 클라이언트의 요청대로 로직 수행 후 결과 리턴 (Model, View)
>    - @Controller는 View 기술을 사용
> 3. @getMapping
>    - annotation (컴파일러가 알아보는 주석)
>    - 해당 주소가 입력되면 동작
>
> [![image-20191223103736629](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191223103736629.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191223103736629.png)
>
> 1. @RequestMapping
>    - get, post 등 어떤 방법으로 request할지 명시할 수 있는 어노테이션
> 2. loggerFactory
>    - 로그를 파일에 저장해주는 역할
>    - 출력속도가 빠르다
>    - 파일등을 이용하여 관리가 용이하다
>
> ※ 단축키
>
> ctrl+shift+ o: 나에게 맞춰 모든 패키지 자동 import
>
> ctrl+shift+F :자동 줄맞춤
>
> ※ 설정
>
> - 한글설정
>   - window->preference -> encoding 모두 utf-8로 설정
>
> [![image-20191223131154641](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191223131154641.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191223131154641.png)
>
> ```java
> @Controller
> public class HtmlController {
> 	@GetMapping("html/string")
> 	public String html() {  //return 값이 string
> 		return "html/string"; //templates/html.string
> 	}
> 
> 	@GetMapping("html/void")
> 	public void htmlVoid() {
> 	}
> 
> 	@GetMapping("html/map")
> 	public Map<String, Object> htmlMap(Map<String, Object> map) {
> 		Map<String, Object> map2 = new HashMap<String, Object>();
> 		return map2;
> 	}
> 
> 	@GetMapping("html/model")
> 	public Model htmlModel(Model model) {
> 		return model;
> 	}
> 
> 	@GetMapping("html/model_and_view")
> 	public ModelAndView htmlModel() {
> 		ModelAndView mav = new ModelAndView();
> 		mav.setViewName("html/model_and_view");
> 		return mav;
> 	}
> 
> 	@GetMapping("html/object")   // 
> 	public Member htmlObject() {
> 		Member member = new Member();
> 		member.setName("kim");    
> 		return member;
> 	}
> }
> ```
>
> ### 메인메소드, 컨트롤러, 템플릿 설정하기
>
> 1. 메인메소드
>
> [![image-20191223140257705](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191223140257705.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191223140257705.png)
>
> 1. home 페이지 설정
>
> [![image-20191223140539494](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191223140539494.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191223140539494.png)
>
> 콘솔에 로그 뜨도록 설정
>
> @Slf4j를 이용하면 좀 더 쉽게 만들 수 있음
>
> 1. html에 연결되도록 getmapping
>
> ```java
> @Controller
> public class HtmlController {
> 	@GetMapping("html/string") 
> 	public String html() { 
> 		return "html/string"; 
> 	}
> 
> 	@GetMapping("html/void")
> 	public void htmlVoid() {
> 	}
> 
> 	@GetMapping("html/map")
> 	public Map<String, Object> htmlMap(Map<String, Object> map) {
> 		Map<String, Object> map2 = new HashMap<String, Object>();
> 		return map2;
> 	}
> 
> 	@GetMapping("html/model")
> 	public Model htmlModel(Model model) {
> 		return model;
> 	}
> 
> 	@GetMapping("html/model_and_view")
> 	public ModelAndView htmlModel() {
> 		ModelAndView mav = new ModelAndView();
> 		mav.setViewName("html/model_and_view");
> 		return mav;
> 	}
> 
> 	@GetMapping("html/object")   
> 	public Member htmlObject() {
> 		Member Member = new Member();
> 		Member.setName("kim");
> 		Member.setUserId("katy");
> 		return Member;
> 	}
> }
> ```
>
> > object page는 Member.html 파일을 열어서 보여주는데, Member에 직접 데이터를 setting 해서 보내준다
>
> 1. private 변수 만들기
>
> [![image-20191223142541403](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191223142541403.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191223142541403.png)
>
> > class에서 init변수 만들때 `__init__`으로 만들고, getter setter로 접근할 수 있게 만든것처럼, member의 변수는 private하다
>
> > gettersetter 없이 접근할 수 있게 하는것이 lombok의 @Data이다
>
> ### 응답방식
>
> - HTML : String
> - JSON : map,array,list,object
>   - 데이터만 서버에서 가져오는 경우 JSON형식으로 가져오는것이 일반적이다
>   - JSON을 html에서 제공해주려면 parser가 필요하다
>   - controller에서 json 데이터를 주고받기 위해서는 @responseBody 가 필요하다
> - Responsebody 자동으로 붙여주는 controller: @RestController
>
> [![image-20191223142643784](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191223142643784.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191223142643784.png)
>
> ### Http Method
>
> - 요청 처리 방식
>   - get: 데이터 가져오기
>   - post :데이터 저장
>   - put: 데이터 수정
>   - delete: 데이터 삭제
> - 이 모든것을 크롬 브라우저에서 경험해보려면 크롬에서 restlet client를 검색해서 talend API tester 다운받기
>
> ```
> HTTP
> Hyper Text Transfer Protocol [Secure]
> 
> 암호화 하여 데이터를 전송시킨다.(보안)
> 
> 중간에 해커가 정보를 가로채도 암호화되어있어 해독할 수 없음
> 
> secure라는 인증서를 사서 서버에 업로드하면 http 웹서비스 실행
> 
> 상태를 기억하지 않는다(stateless)
> 
> request하고 response받은적이 있다고 하더라도 서버는 상태를 기억하지 않기 때문에 다시 request할때 다시 정보를 넣어 request해야한다
> 따라서 response를 받으면 client의 cookie에 정보가 저장되어 다음에 서버 request시 상태가 반영될 수 있도록 한다
> Cookie
> 
> __클라이언트 상__에 정보를 저장.
> 
> 기본적으로 웹서버에서 PC로 보내는 작은 파일 저장. 사용자 인증 도와준다. 만료기간이 있어 시간이 지나면 자동 삭제 된다.
> 
> (참고)Cache
> 캐시는 웹 페이지 요소를 저장하기 위한 임시 저장소이다. 특히, 후에 필요할 것 같은 요소들을 저장한다. 이러한 요소들은 그림 파일이나 문서 파일 등이 될 수 있다.
> 
> Session
> 클라이언트에 대한 정보를 __서버__에 저장할 수 있는 공간
> __접속하는 클라이언트 당(브라우저 당) __하나의 세션 생성
> 사물함과 같은 형식으로 저장이 되며 사물함 번호를 클라이언트로 전송
> 번호를 분실하는 경우 새로운 세션 생성하고 다시 클라이언트로 전송
> 설문조사와 같이 여러 단계로 정보 입력시, 로그인 후 사용 내역 저장 등 활용
> Session 실습하기: Login
> controller
> 
> @Controller
> public class SessionController {
> 	@GetMapping("/login")
> 	public String login() {
> 		return "login";
> 	}
> 
> 	@PostMapping("/login")
> 	public String loginPost(User user, HttpSession session) { 
>         //@ModelAttribute("user") User user
>         // 세션은 어디서든지(현재 스프링 서버) 사용 가능
> 		session.setAttribute("user", user);
> 		return "redirect:/main";  //컨트롤러에서 다 처리하지 않고 /main으로 이동(떠넘김)
> 	}
> 
> 	@GetMapping("/main")
> 	public String main() {
> 		return "main";
> 	}
> }
> main.html
> 
> <body>
>  <p th:if="${session.user} != null"
>  th:text="${session.user.userId} + '님 반갑습니다.'"></p>
>  <p th:unless="${session.user} != null">로그인되어 있지 않습니다.</p>
> </body>
> login.html
> 
> <body>
>  <form action="/login" method="post">
>  ID : <input type="text" name="userId"><br>
>  PW : <input type="password" name="userPw"><br>
>  <input type="submit" value="로그인">
>  </form>
> </body>
> 로그인을 하지 않고 main페이지로 들어가면 "로그인이 되어있지 않습니다"가 뜬다
> 
> 한번 로그인 하면 쿠키 정보가 session에 연결되기 때문에 main에 가더라도 사용자 인증이 된 상태가 된다.
> 
> AOP
> Aspect Oriented Programming
> 
> 공통적으로 적용될 모듈(클래스/메소드)을 만든 후 적용하고자 하는 부분의 코드 밖에서 삽입하는 방법
> image-20191224152500941
> 
> 사용분야
> 메소드의 성능 테스트
> 트랜잭션 처리(중간에 하나라도 오류가 생기면 트랜잭션 자체를 취소. for 충돌방지, 하나의 과정이 순차적으로 끝까지 꼭 처리되어야하는 업무)
> 예외반환
> 로깅, 인증, 권한처리
> 파이썬의 데코레이션과 같은 기능
> 용어
> image-20191224152632276
> 
> image-20191224152706437
> 
> 스프링의 두가지 특성
> 
> IoC/DI
> Inversion of Control/ Dependency Injection)
> 제어권을 스프링이 가지고 있음.
> AOP
> 관점지향 프로그램
> AOP 실습하기
> controller
> 
> @Slf4j
> @Aspect
> @Component
> public class ControllerAspect {
> 	@Before(value = "execution (* com.multicampus.basic.controller.*.*(..))")
> 	public void onBeforeHandler(JoinPoint joinPoint) {
> 		log.debug("@Before run");
> 	}
> 
> 	@After(value = "execution (* com.multicampus.basic.controller.*.*(..))")
> 	public void onAfterHandler(JoinPoint joinPoint) {
> 		log.debug("@After run");
> 	}
> 
> 	@AfterReturning(value = "execution (* com.multicampus.basic.controller.*.*(..))", returning = "data")
> 	public void onAfterReturningHandler(JoinPoint joinPoint, Object data) {
> 		if (data != null) {
> 			log.debug(data.toString());
> 		}
> 		log.debug("@AfterReturning run");
> 	}
> }
> basic.controller에 있는 사이트에 들어갈때마다 @Before run, @After run 등 로그 기록이 콘솔에 뜬다
> 
> 만약 뜨지 않는다면 static.application.properties에
> 
> logging.level.com.multicampus.basic=trace를 입력하기
> 
> ControllerAdvice
> Controller에서 발생되는 오류를 감지하고 처리해주는 기능
> 사용 이유
> 예외처리를 한 곳에 묶어서 편하게 관리
> 처리가 제대로 되지 못한 부분에 예외가 발생되는 경우 브라우저에 Exception Message가 노출되어 버리는데 모든 예측하지 못한 예외도 한꺼번에 처리 가능
> request 했는데 오류 발생 -> 오류에 해당하는 ControllerAdvice 찾아 response
> @ControllerAdvice
> public class MyControllerAdvice {
>  @ExceptionHandler
>  [@ResponseStatus]
>  [@ResponseBody] //json으로 응답을 줌
>  public String handle(RuntimeException e, WebRequest request) {
>  return [view]; 
>  }
> }
> 또는 AOP에서 *.* 모든클래스 모든 메소드를 선택하는 것이 아니라 부분적으로 선택해서 Log.를 에러메세지 보내도록 하는 방법도 있다.
> 
> filter
> 비교
> 
> AOP	Filter	Interceptor
> 어떤 클래스든 어떠한 메소드든 대상이 된다	접속하는 주소(url)대상	접속하는 주소(url)대상
> 자바의 고유기능	자바의 고유기능
> HTTP 요청과 응답을 변경 할 수 있는 클래스
> 사용 분야
> XSS (Cross Site Scripting) 방지
> Logging
> Encoding
> IP 검사 등
> 서버에 접속하기 전 필터를 거쳐 접속(request)하고 response하는 구조(for 보안, 조건확인 등)
> filter파일
> 
> @Slf4j
> public class IPCheckFilter implements Filter {
> @Override
> public void doFilter(
>  ServletRequest request, ServletResponse response, FilterChain chain)
>  throws IOException, ServletException {
> log.debug("filter begin");
> HttpServletRequest req = (HttpServletRequest) request;
> String ip = request.getRemoteAddr();
> log.debug("ip : " + ip);
> chain.doFilter(req, response);
> log.debug("filter end");
> }
> }
> 필터가 적용되려면 configuration에 필터를 등록해야한다
> 
> @Configuration
> public class FilterConfig {
> @Bean
> public FilterRegistrationBean<Filter> getFilterRegistrationBean() {
> FilterRegistrationBean<Filter> bean =
> new FilterRegistrationBean<>(new IPCheckFilter());
> bean.addUrlPatterns("/visitor"); //visitor에 갈때마다 필터 적용
> return bean;
> }
> }
> Interceptor
> ■ Interceptor
> 
> ● Controller에 들어오는 요청 및 응답을 가로채는 역할
> 
> ● Filter와 유사하지만 동작하는 시기가 다름
> 
> ● 주요 메소드 - preHandler() : Controller의 메소드가 실행되기 전 (요청)
> 
> postHandler() : Controller의 메소드가 실행된 후 (응답)
> afterCompletion()
> View가 Rendering 된 이후
> Interceptor 파일
> 
> @Component
> @Slf4j
> public class SignInCheckInterceptor extends HandlerInterceptorAdapter {
> 	@Override
> 	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
> 			throws Exception {
> 		log.debug("preHandle");
> 		HttpSession session = request.getSession();
> 		User user = (User) session.getAttribute("user");
> 		if (user == null) {
> 			response.sendRedirect("/login");
> 		}
> 		return super.preHandle(request, response, handler);
> 	}
> 
> 	@Override
> 	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
> 			ModelAndView modelAndView) throws Exception {
> 		log.debug("postHandle");
> 		super.postHandle(request, response, handler, modelAndView);
> 	}
> 
> 	@Override
> 	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
> 			throws Exception {
> 		log.debug("afterCompletion");
> 		super.afterCompletion(request, response, handler, ex);
> 	}
> }
> config파일
> 
> @Configuration
> public class InterceptorConfig implements WebMvcConfigurer {
> 	@Autowired
> 	private SignInCheckInterceptor signInCheckInterceptor;
> 
> 	@Override
> 	public void addInterceptors(InterceptorRegistry registry) {
> 		registry.addInterceptor(signInCheckInterceptor).addPathPatterns("/main"); //main으로 갈때마다 intercept해서 로그인하게 함
> 		WebMvcConfigurer.super.addInterceptors(registry);
> 	}
> }
> JPA
> Java Persistence API
> ORM 프레임워크 (Object Relational Mapping) - 객체는 객체대로, 관계형 데이터베이스는 관계형
> 객체는 객체대로, 관계형 데이터베이스는 관계형 데이터베이스대로 설계
> 파이썬의 sql alchemy와 비슷
> 특징
> DAO와 Database Table의 강한 의존성 문제 해결
> Model(자바 클래스)을 작성하면 자동으로 Table 생성
> SQL 문장을 이용하지 않고 메소드를 호출하면 자동으로 SQL 문장 실행
> 장점
> 생산성 향상
> 유지보수
> 특정 벤더(DB; Oracle, MSSQL 등)에 종속적이지 않음
> application.properties
> 
> #log level
> logging.level.com.multicampus.basic=trace
> 
> # datasource
> spring.datasource.url=jdbc:h2:~/test
> spring.datasource.driverClassName=org.h2.Driver
> spring.datasource.username=sa
> spring.datasource.password=
> 
> # jpa
> spring.jpa.hibernate.ddl-auto=update
> spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
> spring.jpa.show-sql=true
> H2 데이터베이스 설치
> https://h2database.com/html/main.html
> 다운로드
> H2 Database란?
> 자바로 작성된 관계형 데이터 베이스 관리 시스템.
> 
> 서버모드와 임베디드 모드의 인메모리 DB기능을 지원.
> 
> 브라우저 기반의 콘솔모드를 이용할 수 있으며, 별도의 설치과정이 없고 저용량이라 가볍고 빠른것이 특징.
> 
> image-20191224172637148
> JPA 실습하기
> model파일 만들기
> 
> package com.multicampus.basic.model;
> 
> import javax.persistence.Entity;
> import javax.persistence.GeneratedValue;
> import javax.persistence.GenerationType;
> import javax.persistence.Id;
> 
> import lombok.Data;
> 
> @Data
> @Entity //테이블을 만들때 필요한 정보를 가져오는 매서드
> public class Product {
> 	@Id
> 	@GeneratedValue(strategy = GenerationType.AUTO)
> 	private long id;
> 	private String name;
> 	private int price;
> 	private int count;
> }
> 메모리에 등록하는 어노테이션. 불리어질 대상 (Autowired로 연결하여 spring이 자동으로 제어하게 한다)
> @Controller
> @Service
> @Repository
> @Component
> repository
> 
> 실제로 db를 관리하는 곳
> 
> 메모리에 등록해주는 역할
> 
> interface : 상속받음
> 
> Product라는 table 대상, Long이라는 id
> 
> @Repository
> public interface ProductRepository extends JpaRepository<Product, Long> {
> }
> Controller
> 
> Autowired = 자동으로 Repository를 연결해줌 (메모리에 올라와있는 것 중)
> 
> @RestController
> public class JpaController {
> @Autowired // 자동으로 만듦
> ProductRepository productRepository; //초기화 없이 주입
> @GetMapping("/jpa/product")
> public List<Product> product() {
> List<Product> list = productRepository.findAll();
> return list;
> }
> @PostMapping("/jpa/product")
> public String productPost(@ModelAttribute Product product) {
> productRepository.save(product); //save 알아서 매소드 호출(삽입).매소드가 실행후 product에 반환
> return "redirect:/jpa/product";
> }
> }
> POST 방식으로 Product Table(데이터베이스)에 정보 입력
> 
> Talend API 크롬 확장프로그램 이용
> 
> image-20191224180753804
> 
> H2에 접속하여 SQL 구문으로 테이블 호출
> 
> SELECT * FROM PRODUCT
> 
> 
> SQL구문 대신 Spring repository에서 Java구문으로 데이터 필터링하기
> image-20191226090936880/
> 
> image-20191226090918235
> 
> 이름이 kim인 사람만 테이블에서 불러오기
> Controller
> 
> 단 Product 하나만을 불러오기 때문에 name은 중복되지 않는 고유한 값이어야 한다
> 
> 중복되는 값을 key값으로써 불러오기 위해서는 1) List형식으로 불러오거나 2) 예외처리를 해야한다
> 
> 	@GetMapping("/jpa/product2")
> 	public Product product2(String name) {
> 		Product list = productRepository.findByName(name);
> 		return list;
> 	}
> Repository
> 
> @Repository
> public interface ProductRepository extends JpaRepository<Product, Long> {
> 	public Product findByName(String name);
> }
> webpage
> 
> image-20191226093800010
> 
> 
> 중복되는 값을 key값으로써 불러오기 위해 List형식으로 불러오기
> Controller
> 
> @GetMapping("/jpa/product2")
> 	public List<Product> product2(String name) {
> 		List<Product> list = productRepository.findByName(name);
> 		return list;
> 	}
> Repository
> 
> @Repository
> public interface ProductRepository extends JpaRepository<Product, Long> {
> 	public List<Product> findByName(String name);
> }
> web
> 
> image-20191226093714526
> 
> 
> 
> 
> H2를 서버에서 실행하기
> embeded 모드 : 로컬에서만 접속가능
> sever 모드: 어떤 장치에서든 접속 가능
> h2설정변경
> 
> image-20191226094320639
> 
> application.properties
> 
> # h2 server mode
> spring.datasource.url=jdbc:h2:tcp://localhost/~/test
> 
> 파일 업로드 페이지
> MultipartHttpServletRequest 이용하기
> controller/UploadController (오리지널 파일 이름 확인하기)
> 
> @Controller
> public class UploadController {
> @GetMapping("/upload1") //파일 업로드 화면은 get
> public String upload1() {
> return "upload1";
> }
> @PostMapping("/upload1") //파일 업로드 submit시에는 post방식으로 접근(파일명 확인. 저장X)
> @ResponseBody
> public String upload1Post(MultipartHttpServletRequest mRequest) {
> String result = "";
> MultipartFile mFile = mRequest.getFile("file");  //html의 name으로 파일(mutipartfile) 확인
> String oName = mFile.getOriginalFilename();
> result += oName + "\n";
> return result;
> }
> }
> controller/UploadController (업로드한 파일들 저장하기)
> 
> @Controller
> public class UploadController {
> 	@GetMapping("/upload1")
> 	public String upload1() {
> 		return "upload1";
> 	}
> 
> 	@PostMapping("/upload1")
> 	@ResponseBody
> 	public String upload1Post(MultipartHttpServletRequest mRequest) {
> 		String result = "";
> 		// 여러개의 파일을 담는 list 형식. 반복문이 가능하다
> 		List<MultipartFile> mFiles = mRequest.getFiles("file");
> 		for (int i = 0; i < mFiles.size(); i++) {
> 			
> 			// 업로드된 파일 정보
> 			MultipartFile mFile = mFiles.get(i);
> 			// original 파일명을 알아내기
> 			String oName = mFile.getOriginalFilename();
> 			// 지정 경로에 지정 파일명으로 저장(original 파일명으로)
> 			try {
> 				mFile.transferTo(new File("c:/dev/" + oName));
> 			} catch (IllegalStateException e) {
> 				// TODO Auto-generated catch block
> 				e.printStackTrace();
> 			} catch (IOException e) {
> 				// TODO Auto-generated catch block
> 				e.printStackTrace();
> 			}
> 			result += oName + "\n";
> 		}
> 		return result;
> 	}
> templates/upload1. html
> 
> <meta charset="utf-8">
> <form method="post" enctype="multipart/form-data">
>  <input type="file" name="file" multiple><br>
>  <input type="submit" value="업로드">
> </form>
> application.properties
> 
> # file upload
> spring.servlet.multipart.max-file-size=2097152  //파일 1개의 용량 제한
> spring.servlet.multipart.max-request-size=2097152 //한번의 업로드(request)당 용량 제한
> RequestParam으로 받기
> controller
> 
> @GetMapping("/upload2")
> public String upload2() {
> return "upload2";
> }
> @PostMapping("/upload2")
> @ResponseBody
> public String upload2Post(@RequestParam("file") MultipartFile mFile) {
> String result = "";
> String oName = mFile.getOriginalFilename();
> result += oName + "\n";
> return result;
> }
> templates
> 
> <meta charset="utf-8">
> <form method="post" enctype="multipart/form-data">
> <input type="file" name="file" multiple><br>
> <input type="submit" value="업로드">
> </form>
> ModelAttribute로 받기
> Controller
> 
> @GetMapping("/upload3")
> public String upload3() {
> return "upload3";
> }
> @PostMapping("/upload3")
> @ResponseBody
> public String upload3Post(@ModelAttribute FileInfo info) {
> String result = "";
> String oName = info.getFile().getOriginalFilename();
> result += oName + "\n";
> return result;
> }
> model
> 
> package com.ggoreb.basic.model;
> import org.springframework.web.multipart.MultipartFile;
> import lombok.Data;
> @Data
> public class FileInfo {
> private MultipartFile file;
> }
> templates
> 
> <meta charset="utf-8">
> <form method="post" enctype="multipart/form-data">
>  <input type="file" name="file" multiple><br>
>  <input type="submit" value="업로드">
> </form>
> 
> 
> 
> 파일 다운로드
> controller
> 
> @Controller
> public class DownloadController {
> 	@GetMapping("/download")
> 	public ResponseEntity<Resource> download() throws Exception {
> 		File file = new File("C:/Users/mdyo_/Pictures/question/vector.PNG");
> 		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
> 		return ResponseEntity.ok()
> 				.header("content-disposition", "filename=" + URLEncoder.encode(file.getName(), "utf-8"))
> 				
> 				.contentLength(file.length())
>                   //브라우저에 보여주는 이미지타입으로 인식하게 하기
>                 //.contentType(MediaType.parseMediaType("image/png"))
> 				  // 다운로드 받아야할 파일로 인식하게 하기		           
>                 .contentType(MediaType.parseMediaType("application/octet-stream"))
> 				.body(resource);
> 	}
> }
> Mime-type
> 
> 파일을 어떻게 인식할지 파일타입을 정하는 것
> 
> ("image/png")) : /브라우저에 보여주는 이미지타입으로 인식
> 
> ("application/octet-stream")):다운로드 받아야할 파일로 인식(모든파일)
> 
> ("text/html"): html 파일 브라우저에서 실행했을때의 타입으로 인식
> 
> ("text/plain"): 텍스트파일 문자를 그대로 보여주도록 인식
> 
> RestTemplate
> HTTP 통신에 유용하게 사용할 수 있는 라이브러리
> 
> 기계적이고 반복적인 코드를 최대한 줄여줌
> 
> JSON / XML 형식의 응답결과에 대해 처리 지원
> 
> 주요메소드
> 
> image-20191226124441427
> 
> STS(Spring Tool Suite)에서 import 하는법
> General
> 
> Existing Project
> 
> 프로젝트가 완성이 되어있는경우
> 
> Git
> 
> Projects from git
> 
> Github에서 clone할때(불완전)
> 
> Gradle
> 
> 프로젝트 파일이 불완전할때 파일을 보충하면서 import
> 
> 
> 
> 카카오지도 API에서 위도 경도 정보 가져와서 브라우저 console에 출력
> controller1
> 
> @GetMapping("/getKakao")
> 	public ResponseEntity<Map> getKakao(
> 			@RequestParam("address") String address) { //RequestParam으로 변수 받기
> 		RestTemplate rt = new RestTemplate();
> 		RequestEntity requestEntity = null;
> 		try {
> 			requestEntity = RequestEntity
> 					.get(new URI("https://dapi.kakao.com/v2/local/search/address.json?query="
> 							+ URLEncoder.encode(address, "utf-8")))
> 					.header("Authorization", "KakaoAK <인증키>").build();
> 		} catch (UnsupportedEncodingException e) {
> 			e.printStackTrace();
> 		} catch (URISyntaxException e) {
> 			e.printStackTrace();
> 		}
> 		ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
> 		return entity;
> 	}
> controller 2
> 
> @Controller
> public class serviceController {
> 	@GetMapping("/kakao")
> 	public String kakao() {
> 		return "kakao";
> 	}
> html
> 
> <meta charset="UTF-8">
> <input type="text" id="address">
> <button>위도/경도 변환</button>
> <hr>
> <!--  자바스크립트(jQuery) AJAX활용 -->
> <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
> <!--  getKakao 주소를 호출 -->
> <!--  parsing 후 화면에 출력 -->
> <script>
> 	$('button').click(function(){
> 		$.ajax({
> 			url : '/getKakao',
> 			type : 'get',
> 			data : {'address': $('#address').val()},
> 			success: function(res){
> 				console.log(res);
> 			}
> 		})
> 	});
> 
> </script>
> 
> PAPAGO API를 이용해서 번역한 문장 json파일로 웹에서 보여주기
> @GetMapping("/getNaver")
> 	 public ResponseEntity<Map> getNaver(
> 			 @RequestParam("translate") String translate) {
> 	 RestTemplate rt = new RestTemplate();
> 	 RequestEntity<Map<String, String>> requestEntity = null;
> 	 try {
> 	 Map<String, String> body = new HashMap<>();
> 	 body.put("source", "ko");
> 	 body.put("target", "en");
> 	 body.put("text", translate);
> 	 requestEntity = RequestEntity.post(
> 	 new URI("https://openapi.naver.com/v1/papago/n2mt"))
> 	 .header("X-Naver-Client-Id", "<ID>")
> 	 .header("X-Naver-Client-Secret", "<SECRET_KEY>")
> 	 .body(body);
> 	 } catch (URISyntaxException e) {
> 	 e.printStackTrace();
> 	 }
> 	 ResponseEntity<Map> entity = rt.exchange(requestEntity, Map.class);
> 	 return entity;
> }
> controller 2
> 
> 	@GetMapping("/papago")
> 	public String papago() {
> 		return "papago";
> 	}
> html
> 
> <meta charset="UTF-8">
> <input type="text" id="translate">
> <button>번역 실행</button>
> <hr>
> <!--  자바스크립트(jQuery) AJAX활용 -->
> <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
> <!--  getNaver 주소를 호출 -->
> <!--  parsing 후 화면에 출력 -->
> <script>
> 	$('button').click(function(){
> 		$.ajax({
> 			url : '/getNaver',
> 			type : 'get',
> 			data : {'translate': $('#translate').val()},
> 			success: function(res){
> 				console.log(res); //콘솔에 출력
> 				document.write(res.message.result.translatedText); //화면에 출력
> 			}
> 		})
> 	});
> 
> </script>
> 
> html(번역한 문장 누적으로 계속 보여주기)
> 
> <script>
> 	$('button').click(function(){
> 		$.ajax({
> 			url : '/getNaver',
> 			type : 'get',
> 			data : {'translate': $('#translate').val()},
> 			success: function(res){
> 				console.log(res); 
> 				var translatedText = res.message.result.translatedText;
> 				var html = '<h1>'+ translatedText + '</h1>'
> 				$('hr').after(html);
> 			}
> 		})
> 	});
> </script>
> html(번역한 문장 누적으로 console에는 보여주지만 웹페이지에서는 최근 번역문장만 보여주기)
> 
> <script>
> 	$('button').click(function(){
> 		$.ajax({
> 			url : '/getNaver',
> 			type : 'get',
> 			data : {'translate': $('#translate').val()},
> 			success: function(res){
> 				$('h1').empty();
> 				console.log(res);
> 				var translatedText = res.message.result.translatedText;
> 				var html = '<h1>'+ translatedText + '</h1>'
> 				$('hr').after(html);
> 				
> 			}
> 		})
> 	});
> 
> </script>
> 
> find 단축키
> shift +ctrl +R
> ```
>
> - rest 방식
>
> 같은 주소에 매소드 방식(접근방식)에 따라 달리 작동하도록 설정해두는 방식. 주소, 게시글 등 페이지를 관리하기가 더 용이하다.
>
> ### 요청처리(request하면서 값을 보내는 방식, 형식)
>
> 1. RequestParam(편리함)
>
> - 파라미터의 종류 갯수와 상관없이 요청 처리
> - 파라미터 명칭에 맞게 변수 사용 (컨트롤러 메소드의 인자명과 동일)
> - 보안 약함
> - ex1) key1, key2 정확하게 파라미터 받기
>
> [![image-20191223160442272](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191223160442272.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191223160442272.png)
>
> - ex2) 어떤 파라미터든 받을 수 있게
>
> [![image-20191223160502409](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191223160502409.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191223160502409.png)
>
> 1. ModelAttribute(명확함)
>
> - Model에 작성되어 있는 변수/자료형과 파라미터명이 동일하면 자동으로 대입
> - 모델 클래스의 변수명과 동일
>
> - Model/DTO/VO 등 객체와 연계하여 활용
> - 깐깐한 조건을 다 만족해야 request 처리
> - JPA, MyBatis 등 ORM 프레임워크 활용
> - 개발자 입장에서 controller에서 key에게 바로 key를 셋팅할 수 있는 RequestParam와는 다르게, ModelAttribute는 class를 만들어 key를 관리하기 때문에 한번 더 생각하고, 확인하고,getter setter를 통해 key를 private하게 관리할 수 있다.
>
> [![image-20191224100801040](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191224100801040.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191224100801040.png)
>
> 1. HttpServletRequest - 가장 전통적으로 사용되는 방식
> 2. @PathVariable - 요청을 처리하는 주소에 {변수명} 형식으로 지정
>
> #### 실습하기
>
> ```java
> package com.multicampus.basic.controller;
> 
> import javax.servlet.http.HttpServletRequest;
> 
> import org.springframework.web.bind.annotation.GetMapping;
> import org.springframework.web.bind.annotation.RequestParam;
> import org.springframework.web.bind.annotation.RestController;
> 
> @RestController
> public class RequestController {
> 	@GetMapping("req/http")
> 	public String http(HttpServletRequest request) {
> 		String name = request.getParameter("name");
> 		String pageNum = request.getParameter("pageNum");
> 		return name + ", " + pageNum;
> 	}
> 
> 	@GetMapping("req/param1")
> 	public String param1(
> 			@RequestParam("key1") String key1,
> 			@RequestParam("key2") String key2) {
> 		return key1 + ", " + key2;
> 	}
> 
> }
> http://localhost:8080/req/param1?key1=a&key2=b
> ```
>
> > key1과 key2의 값을 넣어 요청하면 a,b를 출력
>
> ```
> http://localhost:8080/req/param2?key1=a&key2=b&&key=12345
> ```
>
> > {key1=a, key2=b, key=12345} 이런식으로 보여준다
>
> ### 로그인 화면 만들기
>
> - get방식으로 접근했을때에는 로그인 입력창 보이기(login.html 불러오기)
> - 로그인 정보 입력시 post 방식으로 접근하게됨=>로그인 결과 보여주기
>   - boot/ 1234입력시 "로그인 성공" 이 나오는 조건
>
> - controller
>
> ```java
> package com.multicampus.basic.controller;
> 
> import org.springframework.stereotype.Controller;
> import org.springframework.web.bind.annotation.GetMapping;
> import org.springframework.web.bind.annotation.PostMapping;
> import org.springframework.web.bind.annotation.RequestParam;
> import org.springframework.web.bind.annotation.ResponseBody;
> 
> @Controller 
> public class LoginController {
> 	@GetMapping("/Login")  //브라우저에서 get방식으로 접근시 login.html을 보여줌
> 	public String login() {
> 		return "login";
> 	}
> 	@PostMapping("/Login")  //post방식으로 접근시 (ResponseBody를 통해)JSON파일 가져와 보여줌
> 	@ResponseBody
> 	public String loginPost(
> 			@RequestParam("id") String id,  //requestParam방식; 정확히 키 입력해야함
> 			@RequestParam("pw") String pw
> 			) {
> 		
> 		String dbId= "boot";
> 		String dbPw = "1234";
> 		
> 		if(dbId.equals(id) && dbPw.equals(pw)) {
> 			return "로그인 성공";
> 		}
> 		return "로그인 실패";
> 	}
> 
> }
> ```
>
> - login.html
>
> ```html
> <!DOCTYPE html>
> <html>
> <head>
> <meta charset="UTF-8">
> <title>Insert title here</title>
> </head>
> <body>
> 	<form method="post" action="/Login">
> 	ID : <input type="text" name="id"><br>
> 	PW : <input type="text" name="pw"><br>
> 	
> 	<input type="submit">
> 	
> 	</form>
> </body>
> </html>
> ```
>
> ### HTML Template – Thymeleaf
>
> 컨트롤러가 요청 받아서 처리하고 응답 주기전에 html에게 작업을 넘겨 처리후 response
>
> html작업 넘길 때 단서를 줘서 특정하게 동작하도록 하는 기술
>
> [![image-20191223162819796](https://github.com/dayoungMM/TIL/raw/master/spring/02_basic_grammer.assets/image-20191223162819796.png)](https://github.com/dayoungMM/TIL/blob/master/spring/02_basic_grammer.assets/image-20191223162819796.png)
>
> ### thymeleaf 를 이용한 html페이지에서 변수 표현하는 방법 3가지
>
> ```html
> <!DOCTYPE html>
> <html xmlns:th="http://www.thymeleaf.org">
> <head>
> <meta charset="UTF-8">
> <title>Insert title here</title>
> </head>
> <body>
> 	아이디:<span>[[${user.userId}]]</span>
> 	<br> 
> 	이름:	<span>[[${user.userName}]]</span>
> 	<br> 
> 	나이:	<span>[[${user.userAge}]]</span>
> 	<br>
> 	<hr>
> 	아이디:<span th:text="${user.userId}"></span><br> 
> 	이름:	<span th:text="${user.userName}"></span><br> 
> 	나이:	<span th:text="${user.userAge}"></span><br>
> 	<hr>
> 	아이디:<span data-th-text="${user.userId}"></span><br> 
> 	이름:	<span data-th-text="${user.userName}"></span><br> 
> 	나이:	<span data-th-text="${user.userAge}"></span><br>
> </body>
> </html>
> ```
>
> ### Thymeleaf ) 하나씩 for문처럼 뽑아내기 방법 2가지
>
> > 테이블 형식을 쓸 때 사용한다
> >
> > for each 와 동작하는 방식이 비슷하다고 생각하면 된다
>
> ```html
> </tr>
> <tr th:each="user : ${userList}">
> <td th:text="${user.userId}"></td>
> <td th:text="${user.userName}"></td>
> <td th:text="${user.userAge}"></td>
> </tr>
> </table>
> <hr>
> <th:block th:each="pageNumber : ${#numbers.sequence(1, 10)}">
> <span th:text="${pageNumber}></span>
> ```
>
> ### Thymeleaf ) 조건문
>
> - if 문
>
> > unless: else와 같음. if문과 형식 똑같이 써야한다
>
> - 삼항연산자
> - switch문
>
> ```html
> <body>
>  관리자 이름 :
>     //if문
>  <span th:if="${name} != null" th:text="${name}"></span>
>  <span th:unless="${name} != null" th:text="이름없음"></span>
>  <br>
>     //삼항연산자
>  권한 : <span th:text="${auth} != null ? ${auth} : '권한없음'"></span><br>
>  담당 카테고리 :
>  <span th:switch="${category}">
>  <span th:case="1">커뮤니티</span>
>  <span th:case="2">장터</span>
>  <span th:case="3">갤러리</span>
>  </span><br>
> </body>
> ```
>
> > 그냥 /mode로 호출하면 "권한없음으로 나옴
> >
> > > `http://localhost:8080/mode?name=이름&auth=권한&category=1`:이런식으로 주소를 입력해야 한다.
>
> ### Thymeleaf ) default 기본값(파라미터) 설정하기
>
> ```java
>  @GetMapping("pagination")
>  public String pagination(Model model, @RequestParam(defaultValue="1") int page) {
>  int startPage = (page - 1) / 10 * 10 + 1;
>  int endPage = startPage + 9;
>  model.addAttribute("startPage", startPage);
>  model.addAttribute("endPage", endPage);
>  model.addAttribute("page", page);
>  return "pagination";
>  }
> ```
>
> - request할때 값을 입력해주지 않으면 default값은 1이다
>
> - page ==20일때 11~20페이지 보여주기 위해 page -1을 함
>
> - page/10*10을 하게 되면 십의자리만 뽑아준다
>
>   ```
>   
>   ```
>
> //현재페이지는 bold처리하기
>
> ~~~java
> ### Thymeleaf ) 하이퍼링크 설정하기
> 
> ```java
>  @GetMapping("/linkUrl")
>  public String linkUrl(
> //			@RequestParam int start,
> //			@RequestParam int end,
>  		@RequestParam (defaultValue="1") int now_page,
>  		Model model) {
>  	int start = (now_page-1)/10*10+1;
>  	int end = start + 9;
>  	model.addAttribute("start",start);
>  	model.addAttribute("end",end);
>  	model.addAttribute("now_page",now_page);
>  	return "linkUrl";
>  }
> <body>
> 	<th:block th:each="page : ${#numbers.sequence(start,end)}">
> 		<span th:if = "${now_page==page}" th:text = "${page}"></span>
> 		<a href="#" th:unless="${now_page==page}">[[${page}]]</a>
> 	
> 	</th:block>
> </body>
> ~~~