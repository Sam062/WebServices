package base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("base")
public class AppConfig {
	@Bean
	public InternalResourceViewResolver ircv() {
		return new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
	}
}
