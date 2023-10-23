package dio.me.edu.dto;

import dio.me.edu.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
@ExtendWith(SpringExtension.class)
public class DtoTest {
    @Test
    void test() {
        assertThat(UserDTO.class, allOf(hasValidGettersAndSetters()));
        assertThat(Account.class, allOf(hasValidGettersAndSetters()));
        assertThat(Card.class, allOf(hasValidGettersAndSetters()));
        assertThat(Feature.class, allOf(hasValidGettersAndSetters()));
        assertThat(News.class, allOf(hasValidGettersAndSetters()));
        assertThat(User.class, allOf(hasValidGettersAndSetters()));
    }
}