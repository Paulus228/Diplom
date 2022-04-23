package test.carshoptiger.repository.Implementation;


import com.carshoptiger.repository.API.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.carshoptiger.config.BeansConfig;

@ContextConfiguration(classes={ BeansConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class CarRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void savecar() {
    }
}