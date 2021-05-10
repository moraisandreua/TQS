# TASK I

![password](https://i.imgur.com/SzNQzMH.png)

![install](https://i.imgur.com/pUEPN8t.png)

![user](https://i.imgur.com/8b5ARJL.png)

![configuration](https://i.imgur.com/VWlA8al.png)

![ready](https://i.imgur.com/WxjVpKi.png)

![install_plugins](https://i.imgur.com/OU1QoEu.png)

![config_jdk](https://i.imgur.com/7W5Ojs0.png)

![config_maven](https://i.imgur.com/nWeRCXt.png)

![config_git](https://i.imgur.com/Q2cM54o.png)

![config_build](https://i.imgur.com/6Iaa7Qj.png)

### Resultado depois do build
```
Started by user Administrator
Running as SYSTEM
Building in workspace /Users/andre/.jenkins/workspace/lab8-p1
The recommended git tool is: NONE
No credentials specified
Cloning the remote Git repository
Cloning repository /Users/andre/Documents/GitHub/TQS
 > git init /Users/andre/.jenkins/workspace/lab8-p1 # timeout=10
Fetching upstream changes from /Users/andre/Documents/GitHub/TQS
 > git --version # timeout=10
 > git --version # 'git version 2.31.1'
 > git fetch --tags --force --progress -- /Users/andre/Documents/GitHub/TQS +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git config remote.origin.url /Users/andre/Documents/GitHub/TQS # timeout=10
 > git config --add remote.origin.fetch +refs/heads/*:refs/remotes/origin/* # timeout=10
Avoid second fetch
 > git rev-parse refs/remotes/origin/master^{commit} # timeout=10
 > git rev-parse origin/master^{commit} # timeout=10
ERROR: Couldn't find any revision to build. Verify the repository and branch configuration for this job.
Finished: FAILURE
```

### Trocando o path para o projeto da aula passada

![aula7_p3_](https://i.imgur.com/DkuGXED.png)


# TASK II

![pipeline](https://i.imgur.com/N1OQLwg.png)

![jenkinsfile](https://i.imgur.com/2Ow6jqT.png)

### Resultado depois do build
```
Started by user Administrator
Lightweight checkout support not available, falling back to full checkout.
Checking out git https://github.com/moraisandreua/TQS.git into /Users/andre/.jenkins/workspace/lab8_pipeline@script to read lab7/P3_/Jenkinsfile
Selected Git installation does not exist. Using Default
The recommended git tool is: NONE
using credential 52035288-be19-4b43-9a99-c4b63aa1a44e
Cloning the remote Git repository
Cloning repository https://github.com/moraisandreua/TQS.git
 > git init /Users/andre/.jenkins/workspace/lab8_pipeline@script # timeout=10
Fetching upstream changes from https://github.com/moraisandreua/TQS.git
 > git --version # timeout=10
 > git --version # 'git version 2.31.1'
using GIT_ASKPASS to set credentials 
 > git fetch --tags --force --progress -- https://github.com/moraisandreua/TQS.git +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git config remote.origin.url https://github.com/moraisandreua/TQS.git # timeout=10
 > git config --add remote.origin.fetch +refs/heads/*:refs/remotes/origin/* # timeout=10
Avoid second fetch
Seen branch in repository origin/main
Seen 1 remote branch
 > git show-ref --tags -d # timeout=10
Checking out Revision 0ecbe9b2ca0fccde55768ab7cafec25e379ee793 (origin/main)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 0ecbe9b2ca0fccde55768ab7cafec25e379ee793 # timeout=10
Commit message: "jenkinsfile"
First time build. Skipping changelog.
Running in Durability level: MAX_SURVIVABILITY
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /Users/andre/.jenkins/workspace/lab8_pipeline
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Checkout SCM)
[Pipeline] checkout
Selected Git installation does not exist. Using Default
The recommended git tool is: NONE
using credential 52035288-be19-4b43-9a99-c4b63aa1a44e
Cloning the remote Git repository
Cloning repository https://github.com/moraisandreua/TQS.git
 > git init /Users/andre/.jenkins/workspace/lab8_pipeline # timeout=10
Fetching upstream changes from https://github.com/moraisandreua/TQS.git
 > git --version # timeout=10
 > git --version # 'git version 2.31.1'
using GIT_ASKPASS to set credentials 
 > git fetch --tags --force --progress -- https://github.com/moraisandreua/TQS.git +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git config remote.origin.url https://github.com/moraisandreua/TQS.git # timeout=10
 > git config --add remote.origin.fetch +refs/heads/*:refs/remotes/origin/* # timeout=10
Avoid second fetch
Seen branch in repository origin/main
Seen 1 remote branch
 > git show-ref --tags -d # timeout=10
Checking out Revision 0ecbe9b2ca0fccde55768ab7cafec25e379ee793 (origin/main)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 0ecbe9b2ca0fccde55768ab7cafec25e379ee793 # timeout=10
Commit message: "jenkinsfile"
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Tool Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (test java installation)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] sh
+ java -version
openjdk version "11.0.9.1" 2020-11-04 LTS
OpenJDK Runtime Environment Corretto-11.0.9.12.1 (build 11.0.9.1+12-LTS)
OpenJDK 64-Bit Server VM Corretto-11.0.9.12.1 (build 11.0.9.1+12-LTS, mixed mode)
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (test maven installation)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] sh
+ mvn -version
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /Users/andre/.mvnvm/apache-maven-3.6.3
Java version: 11.0.9.1, vendor: Amazon.com Inc., runtime: /Users/andre/Library/Java/JavaVirtualMachines/correto/Contents/Home
Default locale: en_PT, platform encoding: UTF-8
OS name: "mac os x", version: "10.16", arch: "x86_64", family: "mac"
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
```

Scheduling e update do Jenkinsfile
![scheduling](https://i.imgur.com/S0glCWD.png)

### Resultado depois do build
(depois de varios builds com failures relacionados com diretorios 😅)

![pipeline_new](https://i.imgur.com/ghDzbUs.png)

```
Started by user Administrator
Lightweight checkout support not available, falling back to full checkout.
Checking out git https://github.com/moraisandreua/TQS.git into /Users/andre/.jenkins/workspace/lab8_pipeline@script to read lab7/P3_/Jenkinsfile
Selected Git installation does not exist. Using Default
The recommended git tool is: NONE
using credential 52035288-be19-4b43-9a99-c4b63aa1a44e
 > git rev-parse --resolve-git-dir /Users/andre/.jenkins/workspace/lab8_pipeline@script/.git # timeout=10
Fetching changes from the remote Git repository
 > git config remote.origin.url https://github.com/moraisandreua/TQS.git # timeout=10
Fetching upstream changes from https://github.com/moraisandreua/TQS.git
 > git --version # timeout=10
 > git --version # 'git version 2.31.1'
using GIT_ASKPASS to set credentials 
 > git fetch --tags --force --progress -- https://github.com/moraisandreua/TQS.git +refs/heads/*:refs/remotes/origin/* # timeout=10
Seen branch in repository origin/main
Seen 1 remote branch
 > git show-ref --tags -d # timeout=10
Checking out Revision 181200e2a18ee8f539f1c92aba1ee06b489b4469 (origin/main)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 181200e2a18ee8f539f1c92aba1ee06b489b4469 # timeout=10
Commit message: "FIX Jenkinsfile"
 > git rev-list --no-walk 07334c1b2a21435ac223cc10fd50544d61fbdd66 # timeout=10
Running in Durability level: MAX_SURVIVABILITY
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /Users/andre/.jenkins/workspace/lab8_pipeline
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Checkout SCM)
[Pipeline] checkout
Selected Git installation does not exist. Using Default
The recommended git tool is: NONE
using credential 52035288-be19-4b43-9a99-c4b63aa1a44e
 > git rev-parse --resolve-git-dir /Users/andre/.jenkins/workspace/lab8_pipeline/.git # timeout=10
Fetching changes from the remote Git repository
 > git config remote.origin.url https://github.com/moraisandreua/TQS.git # timeout=10
Fetching upstream changes from https://github.com/moraisandreua/TQS.git
 > git --version # timeout=10
 > git --version # 'git version 2.31.1'
using GIT_ASKPASS to set credentials 
 > git fetch --tags --force --progress -- https://github.com/moraisandreua/TQS.git +refs/heads/*:refs/remotes/origin/* # timeout=10
Seen branch in repository origin/main
Seen 1 remote branch
 > git show-ref --tags -d # timeout=10
Checking out Revision 181200e2a18ee8f539f1c92aba1ee06b489b4469 (origin/main)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 181200e2a18ee8f539f1c92aba1ee06b489b4469 # timeout=10
Commit message: "FIX Jenkinsfile"
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Tool Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] dir
Running in /Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_
[Pipeline] {
[Pipeline] sh
+ mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------------------< tqs.lab7:p3 >-----------------------------
[INFO] Building p3 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The POM for com.sun.xml.bind:jaxb-osgi:jar:2.2.10 is invalid, transitive dependencies (if any) will not be available, enable debug logging for more details
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ p3 ---
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:resources (default-resources) @ p3 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ p3 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 6 source files to /Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:testResources (default-testResources) @ p3 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ p3 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ p3 ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running tqs.lab7.p3.CarControllerMvcTest
18:51:37.808 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
18:51:37.827 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
18:51:37.884 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [tqs.lab7.p3.CarControllerMvcTest] from class [org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper]
18:51:37.902 [main] INFO org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [tqs.lab7.p3.CarControllerMvcTest], using SpringBootContextLoader
18:51:37.909 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [tqs.lab7.p3.CarControllerMvcTest]: class path resource [tqs/lab7/p3/CarControllerMvcTest-context.xml] does not exist
18:51:37.909 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [tqs.lab7.p3.CarControllerMvcTest]: class path resource [tqs/lab7/p3/CarControllerMvcTestContext.groovy] does not exist
18:51:37.910 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [tqs.lab7.p3.CarControllerMvcTest]: no resource found for suffixes {-context.xml, Context.groovy}.
18:51:37.911 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [tqs.lab7.p3.CarControllerMvcTest]: CarControllerMvcTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
18:51:38.012 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [tqs.lab7.p3.CarControllerMvcTest]
18:51:38.103 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [/Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_/target/classes/tqs/lab7/p3/P3Application.class]
18:51:38.104 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration tqs.lab7.p3.P3Application for test class tqs.lab7.p3.CarControllerMvcTest
18:51:38.107 [main] DEBUG org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper - @TestExecutionListeners is not present for class [tqs.lab7.p3.CarControllerMvcTest]: using defaults.
18:51:38.108 [main] INFO org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.event.ApplicationEventsTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
18:51:38.134 [main] INFO org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@46268f08, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@2a76840c, org.springframework.test.context.event.ApplicationEventsTestExecutionListener@71454b9d, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@eda25e5, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@7cf6a5f9, org.springframework.test.context.support.DirtiesContextTestExecutionListener@623e088f, org.springframework.test.context.transaction.TransactionalTestExecutionListener@39fcbef6, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@66565121, org.springframework.test.context.event.EventPublishingTestExecutionListener@2fc6f97f, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@3d2ee678, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@6179e425, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@35f26e72, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@2d6764b2, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@67304a40, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener@49c6c24f]
18:51:38.140 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@32193bea testClass = CarControllerMvcTest, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@6b8d96d9 testClass = CarControllerMvcTest, locations = '{}', classes = '{class tqs.lab7.p3.P3Application}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper=true}', contextCustomizers = set[[ImportsContextCustomizer@69653e16 key = [org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration, org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration, org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration, org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration, org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration, org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration, org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration, org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration, org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration, org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration, org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration, org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration, org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration, org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration, org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration, org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration, org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcWebClientAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcWebDriverAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration, org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration, org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration, org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration, org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcSecurityConfiguration]], org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@6d026701, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@35399441, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@69456cf4, org.springframework.boot.test.autoconfigure.OverrideAutoConfigurationContextCustomizerFactory$DisableAutoConfigurationContextCustomizer@732d0d24, org.springframework.boot.test.autoconfigure.actuate.metrics.MetricsExportContextCustomizerFactory$DisableMetricExportContextCustomizer@18e36d14, org.springframework.boot.test.autoconfigure.filter.TypeExcludeFiltersContextCustomizer@42abb69, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@38356c3c, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@345f69f3, org.springframework.boot.test.context.SpringBootTestArgs@1, org.springframework.boot.test.context.SpringBootTestWebEnvironment@0], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map[[empty]]], class annotated with @DirtiesContext [false] with mode [null].
18:51:38.201 [main] DEBUG org.springframework.test.context.support.TestPropertySourceUtils - Adding inlined properties to environment: {spring.jmx.enabled=false, org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTestContextBootstrapper=true}

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.5)

2021-05-10 18:51:38.680  INFO 59839 --- [           main] tqs.lab7.p3.CarControllerMvcTest         : Starting CarControllerMvcTest using Java 11.0.9.1 on aluno-0711.wireless.ua.pt with PID 59839 (started by andre in /Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_)
2021-05-10 18:51:38.684  INFO 59839 --- [           main] tqs.lab7.p3.CarControllerMvcTest         : No active profile set, falling back to default profiles: default
2021-05-10 18:51:40.497  INFO 59839 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-05-10 18:51:40.829  INFO 59839 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2021-05-10 18:51:40.829  INFO 59839 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2021-05-10 18:51:40.830  INFO 59839 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 1 ms
2021-05-10 18:51:40.856  INFO 59839 --- [           main] tqs.lab7.p3.CarControllerMvcTest         : Started CarControllerMvcTest in 2.645 seconds (JVM running for 3.876)
200
Content-Type: application/json

[
    {
        "carId": 1,
        "maker": "model3",
        "model": "tesla"
    }
]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.159 s - in tqs.lab7.p3.CarControllerMvcTest
2021-05-10 18:51:41.876  INFO 59839 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.2.0:jar (default-jar) @ p3 ---
[INFO] Building jar: /Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_/target/p3-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.4.5:repackage (repackage) @ p3 ---
[INFO] Replacing main artifact with repackaged archive
[INFO] 
[INFO] --- maven-failsafe-plugin:2.22.2:integration-test (default) @ p3 ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running tqs.lab7.p3.CarIntegrationTestIT
18:51:44.179 [main] DEBUG org.testcontainers.utility.TestcontainersConfiguration - Testcontainers configuration overrides will be loaded from file:/Users/andre/.testcontainers.properties
18:51:44.189 [main] INFO org.testcontainers.dockerclient.DockerClientProviderStrategy - Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
18:51:44.691 [ducttape-0] DEBUG org.testcontainers.dockerclient.DockerClientProviderStrategy - Pinging docker daemon...
18:51:44.725 [ducttape-0] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: 
18:51:45.316 [main] INFO org.testcontainers.dockerclient.DockerClientProviderStrategy - Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
18:51:45.316 [main] DEBUG org.testcontainers.dockerclient.DockerClientProviderStrategy - Transport type: 'okhttp', Docker host: 'unix:///var/run/docker.sock'
18:51:45.316 [main] DEBUG org.testcontainers.dockerclient.DockerClientProviderStrategy - Checking Docker OS type for local Unix socket (unix:///var/run/docker.sock)
18:51:45.319 [main] INFO org.testcontainers.DockerClientFactory - Docker host IP address is localhost
18:51:45.321 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: 
18:51:45.383 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: 
18:51:45.439 [main] INFO org.testcontainers.DockerClientFactory - Connected to docker: 
  Server Version: 20.10.5
  API Version: 1.41
  Operating System: Docker Desktop
  Total Memory: 1987 MB
18:51:45.439 [main] DEBUG org.testcontainers.DockerClientFactory - Ryuk is enabled
18:51:45.443 [main] INFO org.testcontainers.utility.ImageNameSubstitutor - Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
18:51:45.446 [main] DEBUG org.testcontainers.utility.PrefixingImageNameSubstitutor - No prefix is configured
18:51:45.447 [main] DEBUG org.testcontainers.utility.ImageNameSubstitutor - Did not find a substitute image for testcontainers/ryuk:0.3.1 (using image substitutor: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor'))
18:51:45.448 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: testcontainers/ryuk:0.3.1
18:51:45.530 [main] DEBUG org.testcontainers.utility.RegistryAuthLocator - Looking up auth config for image: testcontainers/ryuk:0.3.1 at registry: index.docker.io
18:51:45.531 [main] DEBUG org.testcontainers.utility.RegistryAuthLocator - RegistryAuthLocator has configFile: /Users/andre/.docker/config.json (exists) and commandPathPrefix: 
18:51:45.536 [main] DEBUG org.testcontainers.utility.RegistryAuthLocator - registryName [index.docker.io] for dockerImageName [testcontainers/ryuk:0.3.1]
18:51:45.537 [main] DEBUG org.testcontainers.utility.RegistryAuthLocator - Executing docker credential provider: docker-credential-desktop to locate auth config for: index.docker.io
18:51:45.545 [main] DEBUG org.testcontainers.shaded.org.zeroturnaround.exec.ProcessExecutor - Executing [docker-credential-desktop, get].
18:51:45.585 [main] DEBUG org.testcontainers.shaded.org.zeroturnaround.exec.ProcessExecutor - Started Process[pid=59856, exitValue="not exited"]
18:51:45.757 [WaitForProcess-Process[pid=59856, exitValue="not exited"]] DEBUG org.testcontainers.shaded.org.zeroturnaround.exec.WaitForProcess - Process[pid=59856, exitValue=1] stopped with exit code 1
18:51:45.759 [main] DEBUG org.testcontainers.shaded.org.zeroturnaround.exec.ProcessExecutor - Executing [docker-credential-desktop, get].
18:51:45.764 [main] DEBUG org.testcontainers.shaded.org.zeroturnaround.exec.ProcessExecutor - Started Process[pid=59859, exitValue="not exited"]
18:51:45.815 [WaitForProcess-Process[pid=59859, exitValue="not exited"]] DEBUG org.testcontainers.shaded.org.zeroturnaround.exec.WaitForProcess - Process[pid=59859, exitValue=1] stopped with exit code 1
18:51:45.816 [main] DEBUG org.testcontainers.utility.RegistryAuthLocator - Got credentials not found error message from docker credential helper - credentials not found in native keychain
18:51:45.816 [main] INFO org.testcontainers.utility.RegistryAuthLocator - Credential helper/store (docker-credential-desktop) does not have credentials for index.docker.io
18:51:45.817 [main] DEBUG org.testcontainers.utility.RegistryAuthLocator - No matching Auth Configs - falling back to defaultAuthConfig [null]
18:51:45.817 [main] DEBUG org.testcontainers.dockerclient.AuthDelegatingDockerClientConfig - Effective auth config [null]
18:51:45.820 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: org.testcontainers.shaded.com.github.dockerjava.core.command.CreateContainerCmdImpl@6e4de19b[name=testcontainers-ryuk-a2fad24c-3781-44b4-8dea-6343fb3d0864,hostName=<null>,domainName=<null>,user=<null>,attachStdin=<null>,attachStdout=<null>,attachStderr=<null>,portSpecs=<null>,tty=<null>,stdinOpen=<null>,stdInOnce=<null>,env=<null>,cmd=<null>,healthcheck=<null>,argsEscaped=<null>,entrypoint=<null>,image=testcontainers/ryuk:0.3.1,volumes=com.github.dockerjava.api.model.Volumes@4c6daf0,workingDir=<null>,macAddress=<null>,onBuild=<null>,networkDisabled=<null>,exposedPorts=com.github.dockerjava.api.model.ExposedPorts@10650953,stopSignal=<null>,stopTimeout=<null>,hostConfig=HostConfig(binds=[/var/run/docker.sock:/var/run/docker.sock:rw], blkioWeight=null, blkioWeightDevice=null, blkioDeviceReadBps=null, blkioDeviceWriteBps=null, blkioDeviceReadIOps=null, blkioDeviceWriteIOps=null, memorySwappiness=null, nanoCPUs=null, capAdd=null, capDrop=null, containerIDFile=null, cpuPeriod=null, cpuRealtimePeriod=null, cpuRealtimeRuntime=null, cpuShares=null, cpuQuota=null, cpusetCpus=null, cpusetMems=null, devices=null, deviceCgroupRules=null, deviceRequests=null, diskQuota=null, dns=null, dnsOptions=null, dnsSearch=null, extraHosts=null, groupAdd=null, ipcMode=null, cgroup=null, links=[], logConfig=LogConfig(type=null, config=null), lxcConf=null, memory=null, memorySwap=null, memoryReservation=null, kernelMemory=null, networkMode=null, oomKillDisable=null, init=null, autoRemove=true, oomScoreAdj=null, portBindings=null, privileged=false, publishAllPorts=true, readonlyRootfs=null, restartPolicy=null, ulimits=null, cpuCount=null, cpuPercent=null, ioMaximumIOps=null, ioMaximumBandwidth=null, volumesFrom=null, mounts=null, pidMode=null, isolation=null, securityOpts=null, storageOpt=null, cgroupParent=null, volumeDriver=null, shmSize=null, pidsLimit=null, runtime=null, tmpFs=null, utSMode=null, usernsMode=null, sysctls=null, consoleSize=null),labels={org.testcontainers=true},shell=<null>,networkingConfig=<null>,ipv4Address=<null>,ipv6Address=<null>,aliases=<null>,authConfig=<null>]
18:51:46.097 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: 2f8f23080ea8a82991ecee036c802589d0ced2cfc0fb9d2c5a08efe441587a13
18:51:48.265 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: 2f8f23080ea8a82991ecee036c802589d0ced2cfc0fb9d2c5a08efe441587a13,false
18:51:48.266 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.exec.InspectContainerCmdExec - GET: DefaultWebTarget{path=[/containers/2f8f23080ea8a82991ecee036c802589d0ced2cfc0fb9d2c5a08efe441587a13/json], queryParams={}}
18:51:48.366 [testcontainers-ryuk] DEBUG org.testcontainers.utility.ResourceReaper - Sending 'label=org.testcontainers%3Dtrue&label=org.testcontainers.sessionId%3Da2fad24c-3781-44b4-8dea-6343fb3d0864' to Ryuk
18:51:48.387 [testcontainers-ryuk] DEBUG org.testcontainers.utility.ResourceReaper - Received 'ACK' from Ryuk
18:51:48.389 [main] INFO org.testcontainers.DockerClientFactory - Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
18:51:48.389 [main] DEBUG org.testcontainers.DockerClientFactory - Checks are enabled
18:51:48.389 [main] INFO org.testcontainers.DockerClientFactory - Checking the system...
18:51:48.390 [main] INFO org.testcontainers.DockerClientFactory - ✔︎ Docker server version should be at least 1.6.0
18:51:48.392 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: 2f8f23080ea8a82991ecee036c802589d0ced2cfc0fb9d2c5a08efe441587a13,<null>,true,<null>,<null>,<null>,<null>,{df,-P},<null>,<null>
18:51:48.577 [main] INFO org.testcontainers.DockerClientFactory - ✔︎ Docker environment should have more than 2GB free disk space
18:51:48.580 [main] DEBUG org.testcontainers.utility.PrefixingImageNameSubstitutor - No prefix is configured
18:51:48.580 [main] DEBUG org.testcontainers.utility.ImageNameSubstitutor - Did not find a substitute image for postgres:latest (using image substitutor: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor'))
18:51:48.584 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: ListImagesCmdImpl[imageNameFilter=<null>,showAll=false,filters=org.testcontainers.shaded.com.github.dockerjava.core.util.FiltersBuilder@0]
18:51:48.731 [main] DEBUG 🐳 [postgres:latest] - postgres:latest is not in image name cache, updating...
18:51:48.732 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: postgres:latest
18:51:48.757 [main] DEBUG org.testcontainers.images.AbstractImagePullPolicy - Using locally available and not pulling image: postgres:latest
18:51:48.757 [main] DEBUG 🐳 [postgres:latest] - Starting container: postgres:latest
18:51:48.758 [main] DEBUG 🐳 [postgres:latest] - Trying to start container: postgres:latest (attempt 1/1)
18:51:48.758 [main] DEBUG 🐳 [postgres:latest] - Starting container: postgres:latest
18:51:48.758 [main] INFO 🐳 [postgres:latest] - Creating container for image: postgres:latest
18:51:48.758 [main] DEBUG org.testcontainers.utility.RegistryAuthLocator - Looking up auth config for image: postgres:latest at registry: index.docker.io
18:51:48.758 [main] DEBUG org.testcontainers.utility.RegistryAuthLocator - No matching Auth Configs - falling back to defaultAuthConfig [null]
18:51:48.758 [main] DEBUG org.testcontainers.dockerclient.AuthDelegatingDockerClientConfig - Effective auth config [null]
18:51:48.766 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: org.testcontainers.shaded.com.github.dockerjava.core.command.CreateContainerCmdImpl@76318a7d[name=<null>,hostName=<null>,domainName=<null>,user=<null>,attachStdin=<null>,attachStdout=<null>,attachStderr=<null>,portSpecs=<null>,tty=<null>,stdinOpen=<null>,stdInOnce=<null>,env={POSTGRES_USER=postgre,POSTGRES_PASSWORD=postgre,POSTGRES_DB=postgre},cmd={postgres,-c,fsync=off},healthcheck=<null>,argsEscaped=<null>,entrypoint=<null>,image=postgres:latest,volumes=com.github.dockerjava.api.model.Volumes@2a492f2a,workingDir=<null>,macAddress=<null>,onBuild=<null>,networkDisabled=<null>,exposedPorts=com.github.dockerjava.api.model.ExposedPorts@3277e499,stopSignal=<null>,stopTimeout=<null>,hostConfig=HostConfig(binds=[], blkioWeight=null, blkioWeightDevice=null, blkioDeviceReadBps=null, blkioDeviceWriteBps=null, blkioDeviceReadIOps=null, blkioDeviceWriteIOps=null, memorySwappiness=null, nanoCPUs=null, capAdd=null, capDrop=null, containerIDFile=null, cpuPeriod=null, cpuRealtimePeriod=null, cpuRealtimeRuntime=null, cpuShares=null, cpuQuota=null, cpusetCpus=null, cpusetMems=null, devices=null, deviceCgroupRules=null, deviceRequests=null, diskQuota=null, dns=null, dnsOptions=null, dnsSearch=null, extraHosts=[], groupAdd=null, ipcMode=null, cgroup=null, links=[], logConfig=LogConfig(type=null, config=null), lxcConf=null, memory=null, memorySwap=null, memoryReservation=null, kernelMemory=null, networkMode=null, oomKillDisable=null, init=null, autoRemove=null, oomScoreAdj=null, portBindings={}, privileged=null, publishAllPorts=true, readonlyRootfs=null, restartPolicy=null, ulimits=null, cpuCount=null, cpuPercent=null, ioMaximumIOps=null, ioMaximumBandwidth=null, volumesFrom=[], mounts=null, pidMode=null, isolation=null, securityOpts=null, storageOpt=null, cgroupParent=null, volumeDriver=null, shmSize=null, pidsLimit=null, runtime=null, tmpFs=null, utSMode=null, usernsMode=null, sysctls=null, consoleSize=null),labels={org.testcontainers=true, org.testcontainers.sessionId=a2fad24c-3781-44b4-8dea-6343fb3d0864},shell=<null>,networkingConfig=<null>,ipv4Address=<null>,ipv6Address=<null>,aliases=<null>,authConfig=<null>]
18:51:48.871 [main] INFO 🐳 [postgres:latest] - Starting container with ID: a8a379dff7da6fa990416c9528267fda7047b8d41b3bb96d8bd21023b7e09a90
18:51:48.871 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: a8a379dff7da6fa990416c9528267fda7047b8d41b3bb96d8bd21023b7e09a90
18:51:50.460 [main] INFO 🐳 [postgres:latest] - Container postgres:latest is starting: a8a379dff7da6fa990416c9528267fda7047b8d41b3bb96d8bd21023b7e09a90
18:51:50.461 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: a8a379dff7da6fa990416c9528267fda7047b8d41b3bb96d8bd21023b7e09a90,false
18:51:50.462 [main] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.exec.InspectContainerCmdExec - GET: DefaultWebTarget{path=[/containers/a8a379dff7da6fa990416c9528267fda7047b8d41b3bb96d8bd21023b7e09a90/json], queryParams={}}
18:51:50.475 [ducttape-0] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.command.AbstrDockerCmd - Cmd: a8a379dff7da6fa990416c9528267fda7047b8d41b3bb96d8bd21023b7e09a90,false
18:51:50.475 [ducttape-0] DEBUG org.testcontainers.shaded.com.github.dockerjava.core.exec.InspectContainerCmdExec - GET: DefaultWebTarget{path=[/containers/a8a379dff7da6fa990416c9528267fda7047b8d41b3bb96d8bd21023b7e09a90/json], queryParams={}}
18:51:50.652 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: The files belonging to this database system will be owned by user "postgres".
18:51:50.653 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:50.653 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: This user must also own the server process.
18:51:50.663 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: fixing permissions on existing directory /var/lib/postgresql/data ... ok
18:51:50.663 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:50.663 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: Data page checksums are disabled.
18:51:50.664 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:50.664 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: The default text search configuration will be set to "english".
18:51:50.664 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: The default database encoding has accordingly been set to "UTF8".
18:51:50.664 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: The database cluster will be initialized with locale "en_US.utf8".
18:51:50.675 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: selecting dynamic shared memory implementation ... posix
18:51:50.676 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: creating subdirectories ... ok
18:51:50.699 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: selecting default max_connections ... 100
18:51:50.727 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: selecting default shared_buffers ... 128MB
18:51:50.751 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: selecting default time zone ... Etc/UTC
18:51:50.764 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: creating configuration files ... ok
18:51:51.101 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: running bootstrap script ... ok
18:51:51.824 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: performing post-bootstrap initialization ... ok
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: syncing data to disk ... ok
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT:     pg_ctl -D /var/lib/postgresql/data -l logfile start
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: Success. You can now start the database server using:
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDERR: --auth-local and --auth-host, the next time you run initdb.
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDERR: You can change this by editing pg_hba.conf or using the option -A, or
18:51:52.160 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDERR: initdb: warning: enabling "trust" authentication for local connections
18:51:52.204 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: waiting for server to start....2021-05-10 17:51:52.225 UTC [48] LOG:  starting PostgreSQL 13.2 (Debian 13.2-1.pgdg100+1) on x86_64-pc-linux-gnu, compiled by gcc (Debian 8.3.0-6) 8.3.0, 64-bit
18:51:52.215 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 2021-05-10 17:51:52.236 UTC [48] LOG:  database system is ready to accept connections
18:51:52.215 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 2021-05-10 17:51:52.230 UTC [49] LOG:  database system was shut down at 2021-05-10 17:51:51 UTC
18:51:52.215 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 2021-05-10 17:51:52.226 UTC [48] LOG:  listening on Unix socket "/var/run/postgresql/.s.PGSQL.5432"
18:51:52.281 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT:  done
18:51:52.282 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: server started
18:51:52.523 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:52.523 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:52.523 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:52.523 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: /usr/local/bin/docker-entrypoint.sh: ignoring /docker-entrypoint-initdb.d/*
18:51:52.523 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: CREATE DATABASE
18:51:52.534 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 2021-05-10 17:51:52.551 UTC [50] LOG:  shutting down
18:51:52.534 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 2021-05-10 17:51:52.551 UTC [48] LOG:  background worker "logical replication launcher" (PID 55) exited with exit code 1
18:51:52.534 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 2021-05-10 17:51:52.547 UTC [48] LOG:  aborting any active transactions
18:51:52.534 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: waiting for server to shut down....2021-05-10 17:51:52.547 UTC [48] LOG:  received fast shutdown request
18:51:52.546 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 2021-05-10 17:51:52.561 UTC [48] LOG:  database system is shut down
18:51:52.625 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT:  done
18:51:52.625 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: server stopped
18:51:52.637 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:52.637 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: PostgreSQL init process complete; ready for start up.
18:51:52.637 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDOUT: 
18:51:52.649 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDERR: 2021-05-10 17:51:52.672 UTC [1] LOG:  listening on IPv4 address "0.0.0.0", port 5432
18:51:52.649 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDERR: 2021-05-10 17:51:52.672 UTC [1] LOG:  starting PostgreSQL 13.2 (Debian 13.2-1.pgdg100+1) on x86_64-pc-linux-gnu, compiled by gcc (Debian 8.3.0-6) 8.3.0, 64-bit
18:51:52.660 [main] DEBUG org.testcontainers.containers.output.WaitingConsumer - STDERR: 2021-05-10 17:51:52.683 UTC [1] LOG:  database system is ready to accept connections
18:51:52.661 [main] INFO 🐳 [postgres:latest] - Container postgres:latest started in PT4.081704S
18:51:52.677 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
18:51:52.685 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
18:51:52.720 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [tqs.lab7.p3.CarIntegrationTestIT] from class [org.springframework.boot.test.context.SpringBootTestContextBootstrapper]
18:51:52.731 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [tqs.lab7.p3.CarIntegrationTestIT], using SpringBootContextLoader
18:51:52.734 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [tqs.lab7.p3.CarIntegrationTestIT]: class path resource [tqs/lab7/p3/CarIntegrationTestIT-context.xml] does not exist
18:51:52.734 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [tqs.lab7.p3.CarIntegrationTestIT]: class path resource [tqs/lab7/p3/CarIntegrationTestITContext.groovy] does not exist
18:51:52.735 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [tqs.lab7.p3.CarIntegrationTestIT]: no resource found for suffixes {-context.xml, Context.groovy}.
18:51:52.735 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [tqs.lab7.p3.CarIntegrationTestIT]: CarIntegrationTestIT does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
18:51:52.785 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [tqs.lab7.p3.CarIntegrationTestIT]
18:51:52.870 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [/Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_/target/classes/tqs/lab7/p3/P3Application.class]
18:51:52.872 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration tqs.lab7.p3.P3Application for test class tqs.lab7.p3.CarIntegrationTestIT
18:51:52.965 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [tqs.lab7.p3.CarIntegrationTestIT]: using defaults.
18:51:52.966 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.event.ApplicationEventsTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
18:51:52.985 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@42e22a53, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@57adfab0, org.springframework.test.context.event.ApplicationEventsTestExecutionListener@1949309d, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@5af97169, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@99a78d7, org.springframework.test.context.support.DirtiesContextTestExecutionListener@31da6b2e, org.springframework.test.context.transaction.TransactionalTestExecutionListener@61c76850, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@70242f38, org.springframework.test.context.event.EventPublishingTestExecutionListener@2a22ad2b, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@48c3205a, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@121c54fa, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@4390f46e, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@7c6442c2, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@2d746ce4, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener@5dbf5634]
18:51:52.988 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@4349754 testClass = CarIntegrationTestIT, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@6a2eea2a testClass = CarIntegrationTestIT, locations = '{}', classes = '{class tqs.lab7.p3.P3Application}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true, server.port=0}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@2b50150, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@41c62850, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@710b30ef, org.springframework.boot.test.autoconfigure.actuate.metrics.MetricsExportContextCustomizerFactory$DisableMetricExportContextCustomizer@60297f36, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@27f3b6d6, org.springframework.test.context.support.DynamicPropertiesContextCustomizer@ad4500ef, org.springframework.boot.test.context.SpringBootTestArgs@1, org.springframework.boot.test.context.SpringBootTestWebEnvironment@29626d54], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map['org.springframework.test.context.web.ServletTestExecutionListener.activateListener' -> false]], class annotated with @DirtiesContext [false] with mode [null].
18:51:53.003 [main] DEBUG org.springframework.test.context.support.DependencyInjectionTestExecutionListener - Performing dependency injection for test context [[DefaultTestContext@4349754 testClass = CarIntegrationTestIT, testInstance = tqs.lab7.p3.CarIntegrationTestIT@66c83fc8, testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@6a2eea2a testClass = CarIntegrationTestIT, locations = '{}', classes = '{class tqs.lab7.p3.P3Application}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true, server.port=0}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@2b50150, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@41c62850, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@710b30ef, org.springframework.boot.test.autoconfigure.actuate.metrics.MetricsExportContextCustomizerFactory$DisableMetricExportContextCustomizer@60297f36, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@27f3b6d6, org.springframework.test.context.support.DynamicPropertiesContextCustomizer@ad4500ef, org.springframework.boot.test.context.SpringBootTestArgs@1, org.springframework.boot.test.context.SpringBootTestWebEnvironment@29626d54], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map['org.springframework.test.context.web.ServletTestExecutionListener.activateListener' -> false, 'org.springframework.test.context.event.ApplicationEventsTestExecutionListener.recordApplicationEvents' -> false]]].
18:51:53.029 [main] DEBUG org.springframework.test.context.support.TestPropertySourceUtils - Adding inlined properties to environment: {spring.jmx.enabled=false, org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true, server.port=0}

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.5)

2021-05-10 18:51:53.341  INFO 59851 --- [           main] tqs.lab7.p3.CarIntegrationTestIT         : Starting CarIntegrationTestIT using Java 11.0.9.1 on aluno-0711.wireless.ua.pt with PID 59851 (started by andre in /Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_)
2021-05-10 18:51:53.344  INFO 59851 --- [           main] tqs.lab7.p3.CarIntegrationTestIT         : No active profile set, falling back to default profiles: default
2021-05-10 18:51:54.151  INFO 59851 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2021-05-10 18:51:54.197  INFO 59851 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 39 ms. Found 1 JPA repository interfaces.
2021-05-10 18:51:54.807  INFO 59851 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 0 (http)
2021-05-10 18:51:54.819  INFO 59851 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-05-10 18:51:54.819  INFO 59851 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.45]
2021-05-10 18:51:54.938  INFO 59851 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-05-10 18:51:54.939  INFO 59851 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1390 ms
2021-05-10 18:51:55.123  INFO 59851 --- [           main] o.f.c.internal.license.VersionPrinter    : Flyway Community Edition 7.1.1 by Redgate
2021-05-10 18:51:55.127  INFO 59851 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-05-10 18:51:55.233  INFO 59851 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-05-10 18:51:55.269  INFO 59851 --- [           main] o.f.c.i.database.base.DatabaseType       : Database: jdbc:postgresql://localhost:55009/postgre (PostgreSQL 13.2)
2021-05-10 18:51:55.335  INFO 59851 --- [           main] o.f.core.internal.command.DbValidate     : Successfully validated 1 migration (execution time 00:00.025s)
2021-05-10 18:51:55.368  INFO 59851 --- [           main] o.f.c.i.s.JdbcTableSchemaHistory         : Creating Schema History table "public"."flyway_schema_history" ...
2021-05-10 18:51:55.436  INFO 59851 --- [           main] o.f.core.internal.command.DbMigrate      : Current version of schema "public": << Empty Schema >>
2021-05-10 18:51:55.446  INFO 59851 --- [           main] o.f.core.internal.command.DbMigrate      : Migrating schema "public" to version "001 - init"
2021-05-10 18:51:55.506  INFO 59851 --- [           main] o.f.core.internal.command.DbMigrate      : Successfully applied 1 migration to schema "public" (execution time 00:00.088s)
2021-05-10 18:51:55.636  INFO 59851 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2021-05-10 18:51:55.707  INFO 59851 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.30.Final
2021-05-10 18:51:55.832  INFO 59851 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2021-05-10 18:51:55.959  INFO 59851 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL10Dialect
2021-05-10 18:51:56.538  INFO 59851 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2021-05-10 18:51:56.547  INFO 59851 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2021-05-10 18:51:56.933  WARN 59851 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2021-05-10 18:51:57.129  INFO 59851 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-05-10 18:51:57.550  INFO 59851 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 49813 (http) with context path ''
2021-05-10 18:51:57.563  INFO 59851 --- [           main] tqs.lab7.p3.CarIntegrationTestIT         : Started CarIntegrationTestIT in 4.531 seconds (JVM running for 14.122)
2021-05-10 18:51:57.881  INFO 59851 --- [o-auto-1-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2021-05-10 18:51:57.881  INFO 59851 --- [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2021-05-10 18:51:57.882  INFO 59851 --- [o-auto-1-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
http://127.0.0.1:49813/api/cars/roadster
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 16.472 s - in tqs.lab7.p3.CarIntegrationTestIT
2021-05-10 18:52:00.563  INFO 59851 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
2021-05-10 18:52:00.564  INFO 59851 --- [extShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2021-05-10 18:52:00.566  INFO 59851 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2021-05-10 18:52:00.570  INFO 59851 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-failsafe-plugin:2.22.2:verify (default) @ p3 ---
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ p3 ---
[INFO] Installing /Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_/target/p3-0.0.1-SNAPSHOT.jar to /Users/andre/.m2/repository/tqs/lab7/p3/0.0.1-SNAPSHOT/p3-0.0.1-SNAPSHOT.jar
[INFO] Installing /Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_/pom.xml to /Users/andre/.m2/repository/tqs/lab7/p3/0.0.1-SNAPSHOT/p3-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  28.184 s
[INFO] Finished at: 2021-05-10T18:52:01+01:00
[INFO] ------------------------------------------------------------------------
[Pipeline] }
[Pipeline] // dir
Post stage
[Pipeline] junit
Recording test results
[Checks API] No suitable checks publisher found.
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
```


