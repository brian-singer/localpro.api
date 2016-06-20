package at.localpro.external.client.rest;

import java.net.URI;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Validated
public class RestClient {

	@Value("${external.server.url}")
	private String serverUrl;

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate template;

	private final Logger log = LoggerFactory.getLogger(getClass());

	private HttpHeaders headers;

	@PostConstruct
	void initHeaders() {
		headers = createHeaderJsonType();
	}

	public <T> T getByUri(@NotEmpty String uri, ParameterizedTypeReference<T> responseType, Object... uriVariables) {
		URI serverUri = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri).buildAndExpand(uriVariables).encode()
				.toUri();
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		log.info("Request url: {} using GET method", serverUri);
		return template.exchange(serverUri, HttpMethod.GET, httpEntity, responseType).getBody();
	}

	public <T> T queryUnique(@NotEmpty String uri, @NotNull DefaultMapEntry<String, String> pair, ParameterizedTypeReference<T> responseType) {
		URI serverUri = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri).build().toUri();
		serverUri = UriBuilder.fromUri(serverUri).queryParam(pair.getKey(), pair.getValue()).build();

		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		log.info("Request url: {} using GET method", serverUri);
		return template.exchange(serverUri, HttpMethod.GET, httpEntity, responseType).getBody();
	}

	public Object query(@NotEmpty String uri, @NotEmpty List<DefaultMapEntry<String, String>> queryParams) {
		URI serverUri = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri).build().toUri();
		UriBuilder builder = UriBuilder.fromUri(serverUri);
		for (DefaultMapEntry<String, String> query : queryParams) {
			builder = builder.queryParam(query.getKey(), query.getValue());
		}
		serverUri = builder.build();
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		log.info("Request url: {} using GET method", serverUri);
		ResponseEntity<Object> response = template.exchange(serverUri, HttpMethod.GET, httpEntity,
				Object.class);
		return response.getBody();
	}

	public Response post(@NotEmpty String uri, @NotNull Object object, Object... uriParameters) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri);
		URI serverUri;
		if (uriParameters == null) {
			serverUri = builder.build().toUri();
		} else {
			serverUri = builder.buildAndExpand(uriParameters).encode().toUri();
		}
		log.info("Request url: {} using POST method", serverUri);
		HttpEntity<?> httpEntity = new HttpEntity<>(object, headers);
		return template.exchange(serverUri, HttpMethod.POST, httpEntity, Response.class).getBody();
	}

	public void put(@NotEmpty String uri, @NotNull Object object, Object... uriParameters) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri);
		URI serverUri;
		if (uriParameters == null) {
			serverUri = builder.build().toUri();
		} else {
			serverUri = builder.buildAndExpand(uriParameters).encode().toUri();
		}
		log.info("Request url: {} using PUT method", serverUri);
		HttpEntity<?> httpEntity = new HttpEntity<>(object, headers);
		template.exchange(serverUri, HttpMethod.PUT, httpEntity, Response.class);
	}

	public void delete(@NotEmpty String uri, Object... uriParameters) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri);
		URI serverUri;
		if (uriParameters == null) {
			serverUri = builder.build().toUri();
		} else {
			serverUri = builder.buildAndExpand(uriParameters).encode().toUri();
		}
		log.info("Request url: {} using DELETE method", serverUri);
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		template.exchange(serverUri, HttpMethod.DELETE, httpEntity, Response.class);
	}

	private HttpHeaders createHeaderJsonType() {
		return new HttpHeaders() {
			private static final long serialVersionUID = -763880167448323421L;
			{
				// byte[] encodedAuth =
				// Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				// String authHeader = "Basic " + new String(encodedAuth);
				// set("Authorization", authHeader);
				set("Content-Type", javax.ws.rs.core.MediaType.APPLICATION_JSON);
				set("Authorization", apiKey);
			}
		};
	}
}