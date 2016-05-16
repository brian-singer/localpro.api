package at.localpro.external.client.rest;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import at.localpro.dto.LocalProDTO;

@Validated
public class RestClient {

	@Autowired
	private RestTemplate template;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Value("${external.server.url}")
	private String serverUrl;

	// TODO fixme URI parameters with query parameters!
	private static final String QUERY = "?";
	private static final String EQUALS = "=";
	private static final String NEXT = "&";

	static HttpHeaders JSON_HEADER = createHeaderJsonType();

	public Object getByUri(@NotEmpty String uri, Object... uriVariables) {
		HttpEntity<LocalProDTO> httpEntity = new HttpEntity<>(JSON_HEADER);
		String getUri = UriBuilder.fromPath(uri).build(uriVariables).toString();
		String requestUrl = new StringBuilder(serverUrl).append(getUri).toString();
		log.info("Request url: {} using GET method", requestUrl);
		ResponseEntity<Object> response = template.exchange(requestUrl, HttpMethod.GET, httpEntity,
				Object.class);
		return response.getBody();
	}

	public Object queryUnique(@NotEmpty String uri, @NotNull DefaultMapEntry<String, String> pair) {
		StringBuilder urlBuilder = new StringBuilder(serverUrl);
		urlBuilder.append(uri);
		urlBuilder.append(QUERY);
		urlBuilder.append(pair.getKey());
		urlBuilder.append(EQUALS);
		urlBuilder.append(pair.getValue());

		HttpEntity<LocalProDTO> httpEntity = new HttpEntity<>(JSON_HEADER);
		log.info("Request url: {} using GET method", urlBuilder.toString());
		ResponseEntity<Object> response = template.exchange(urlBuilder.toString(), HttpMethod.GET, httpEntity,
				Object.class);
		return response.getBody();
	}

	public Object query(@NotEmpty String uri, @NotEmpty List<DefaultMapEntry<String, String>> queryParams) {
		StringBuilder urlBuilder = new StringBuilder(serverUrl);
		urlBuilder.append(uri);
		urlBuilder.append(QUERY);
		Iterator<DefaultMapEntry<String, String>> queryParamsIterator = queryParams.iterator();
		while (queryParamsIterator.hasNext()) {
			DefaultMapEntry<String, String> pair = queryParamsIterator.next();
			urlBuilder.append(pair.getKey());
			urlBuilder.append(EQUALS);
			urlBuilder.append(pair.getValue());
			if (queryParamsIterator.hasNext()) {
				urlBuilder.append(NEXT);
			}
		}

		HttpEntity<LocalProDTO> httpEntity = new HttpEntity<>(JSON_HEADER);
		log.info("Request url: {} using GET method", urlBuilder.toString());
		ResponseEntity<Object> response = template.exchange(urlBuilder.toString(), HttpMethod.GET, httpEntity,
				Object.class);
		return response.getBody();
	}

	public URI post(@NotEmpty String uriObject, @NotNull Object object, Object... uriParameters) {
		StringBuilder urlBuilder = new StringBuilder(serverUrl);
		String postUri;
		if (uriParameters == null) {
			postUri = uriObject;
		} else {
			postUri = UriBuilder.fromPath(uriObject).build(uriParameters).toString();
		}
		urlBuilder.append(postUri);
		log.info("Request url: {} using POST method", urlBuilder.toString());
		URI uri = template.postForLocation(urlBuilder.toString(), object);
		return uri;
	}

	public void put(@NotEmpty String uriObject, @NotNull Object object, Object... uriParameters) {
		StringBuilder urlBuilder = new StringBuilder(serverUrl);
		String putUri;
		if (uriParameters == null) {
			putUri = uriObject;
		} else {
			putUri = UriBuilder.fromPath(uriObject).build(uriParameters).toString();
		}
		urlBuilder.append(putUri);
		log.info("Request url: {} using PUT method", urlBuilder.toString());
		template.put(urlBuilder.toString(), object);
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