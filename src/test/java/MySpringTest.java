import com.xwq.ApplicationContext;
import com.xwq.entity.User;
import com.xwq.service.UserService;
import org.junit.Test;

public class MySpringTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ApplicationContext("beans.json");
        UserService userService = ctx.getBean("userService", UserService.class);
        User user = userService.getUser(1L);
        System.out.println(user);
    }
}
