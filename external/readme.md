# LocalPro external API Implementation

### Main Repository

git clone [https://github.com/brian-singer/local.pro.git](https://github.com/brian-singer/localpro.git)

### External Rest Spring Project for angular.js and Webservice Implementations

#### Interfaces

[LocalPro](https://github.com/brian-singer/localpro/blob/master/external/src/main/java/at/localpro/ILocalPro.java)

[Events](https://github.com/brian-singer/localpro/blob/master/external/src/main/java/at/localpro/IEvent.java)

[Profile](https://github.com/brian-singer/localpro/blob/master/external/src/main/java/at/localpro/IProfile.java)

### Setup

###### In the rest project configure the application entry:

```java
@Configuration
@Import({
	LocalProProperties.class,
	ProviderConfiguration.class,
	RestClientConfiguration.class,
	ClientServiceConfiguration.class
})
public class ApplicationConfiguration {

}
```

###### Usage

Install a minimum of Tomcat7 and Java7
> Start the Server

Once the server is running
> Access API swagger documentation: [Swag](http://localhost:8080/rest/swag/)
