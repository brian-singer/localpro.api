package at.localpro.external.client.rest;

import java.net.URI;
import java.util.List;

import javax.validation.constraints.NotNull;

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

import at.localpro.dto.LocalProDTO;

@Validated
public class RestClient {

	@Autowired
	private RestTemplate template;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Value("${external.server.url}")
	private String serverUrl;

	private static final String QUERY = "%s={value}";

	static HttpHeaders JSON_HEADER = createHeaderJsonType();

	public Object getByUri(@NotEmpty String uri, Object... uriVariables) {
		HttpEntity<LocalProDTO> httpEntity = new HttpEntity<>(JSON_HEADER);
		URI serverUri = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri).buildAndExpand(uriVariables).encode()
				.toUri();
		log.info("Request url: {} using GET method", serverUri);
		ResponseEntity<Object> response = template.exchange(serverUri, HttpMethod.GET, httpEntity, Object.class);
		return response.getBody();
	}

	public <T> T queryUnique(@NotEmpty String uri, @NotNull DefaultMapEntry<String, String> pair, ParameterizedTypeReference<T> responseType) {
		String query = String.format(QUERY, pair.getKey());
		URI serverUri = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri).query(query)
				.buildAndExpand(pair.getValue()).encode().toUri();

		HttpEntity<LocalProDTO> httpEntity = new HttpEntity<>(JSON_HEADER);
		log.info("Request url: {} using GET method", serverUri);
		return template.exchange(serverUri, HttpMethod.GET, httpEntity, responseType).getBody();
	}

	public Object query(@NotEmpty String uri, @NotEmpty List<DefaultMapEntry<String, String>> queryParams) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri);
		for (DefaultMapEntry<String, String> query : queryParams) {
			builder = builder.queryParam(String.format(QUERY, query.getKey()), query.getValue());
		}
		URI serverUri = builder.build().encode().toUri();
		HttpEntity<LocalProDTO> httpEntity = new HttpEntity<>(JSON_HEADER);
		log.info("Request url: {} using GET method", serverUri);
		ResponseEntity<Object> response = template.exchange(serverUri, HttpMethod.GET, httpEntity,
				Object.class);
		return response.getBody();
	}

	public URI post(@NotEmpty String uri, @NotNull Object object, Object... uriParameters) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serverUrl).path(uri);
		URI serverUri;
		if (uriParameters == null) {
			serverUri = builder.build().toUri();
		} else {
			serverUri = builder.buildAndExpand(uriParameters).encode().toUri();
		}
		log.info("Request url: {} using POST method", serverUri);
		return template.postForLocation(serverUri, object);
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
		template.put(serverUri, object);
	}

	static protected HttpHeaders createHeaderJsonType() {
		return new HttpHeaders() {
			private static final long serialVersionUID = -763880167448323421L;
			{
				// byte[] encodedAuth =
				// Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				// String authHeader = "Basic " + new String(encodedAuth);
				// set("Authorization", authHeader);
				set("Content-Type", javax.ws.rs.core.MediaType.APPLICATION_JSON);
			}
		};
	}
}