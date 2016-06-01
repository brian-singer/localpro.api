package at.localpro.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.client.RestTemplate;

import at.localpro.external.client.rest.RestClient;
import at.localpro.external.client.rest.impl.LocalProRestClient;
import at.localpro.external.client.service.RestHandler;

@Configuration
@ComponentScan(basePackageClasses = LocalProRestClient.class)
public class ClientServiceConfiguration {

	@Value("${external.request.timeout}")
	private Integer timeout;

	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		// Testing of haproxy failed :(
		// Proxy proxy = new Proxy(Proxy.Type.HTTP,
		// new
		// InetSocketAddress("56eee9c77628e14c380000b2@ex-std-node784.prod.rhcloud.com",
		// 51201));
		// factory.setProxy(proxy);
		factory.setReadTimeout(timeout);
		factory.setConnectTimeout(timeout);
		return new RestTemplate(factory);
	}

	@Bean
	public RestClient client() {
		return new RestClient();
	}

	@Bean
	public RestHandler restHandling() {
		return new RestHandler();
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

	@Bean
	public MethodValidationPostProcessor getMethodValidationPostProcessor() {
		MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
		processor.setValidator(validator());
		return processor;
	}

}
