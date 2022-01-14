package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Import(AppV1Config.class)
 * 스프링 빈을 등록할때도 사용할 수 있다.
 */
//@Import(AppV1Config.class) // 생성한 파일 import
@Import({AppV1Config.class, AppV2Config.class}) // 생성한 파일 import
/**
 * 현재 내가 존재하는 패키지와 그 하위를 모두 ComponentScan 하는데,
 * hello.proxy.app 을 하면 이 경로의 패키지만 ComponentScan 한다.
 * 위 AppV1Config 를 그럼 ComponentScan을 안하므로 위에 Import 를 통해 스프링 빈으로 등록한 것이다.
 */
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

}