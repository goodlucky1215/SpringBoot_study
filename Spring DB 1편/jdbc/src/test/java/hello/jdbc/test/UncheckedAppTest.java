package hello.jdbc.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class UncheckedAppTest {

    @Test
    void printEx() {
        Controller controller = new Controller();
        assertThatThrownBy(() -> controller.request())
                .isInstanceOf(RuntimeSQLException.class);
    }

    static class Controller {
        Service service = new Service();

        public void request(){
            service.logic();
        }
    }

    static class Service {

        Repository repository = new Repository();

        public void logic() {
            repository.call();
        }
    }

    static class Repository {

        public void call() {
            try {
                throw new SQLException("ex");
            } catch (SQLException e) {
                throw new RuntimeSQLException(e);
            }

        }
    }

    static class RuntimeSQLException extends RuntimeException {
        public RuntimeSQLException() {
        }
        public RuntimeSQLException(Throwable cause) {
            super(cause);
        }
    }
}
