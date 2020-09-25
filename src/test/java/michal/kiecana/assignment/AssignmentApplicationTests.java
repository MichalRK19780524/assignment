package michal.kiecana.assignment;

import michal.kiecana.assignment.services.connect.ConnectNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AssignmentApplicationTests {

    @Autowired
    private ConnectNumberService connectNumberService;

    @Test
    void contextLoads() {
        assertThat(connectNumberService).isNotNull();
    }

}
