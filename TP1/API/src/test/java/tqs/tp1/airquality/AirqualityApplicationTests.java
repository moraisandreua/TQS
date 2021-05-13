package tqs.tp1.airquality;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AirqualityApplicationTests {
    Utils utils = new Utils("ToKiO_errors");
    @Test
    void contextLoads() {
        assertTrue(!utils.checkName());
    }

}
// sonarqube token
// camoans: 4f644d8d1400abb850a22331791cde42da7c1f3b

/*
mvn sonar:sonar \
-Dsonar.projectKey=airquality \
-Dsonar.host.url=http://localhost:9000 \
-Dsonar.login=4f644d8d1400abb850a22331791cde42da7c1f3b
*/