package dao;

import com.bnisler.config.DataConfig;
import com.bnisler.config.WebAppConfig;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class, WebAppConfig.class})
@ComponentScan(value = "com.bnisler")
@WebAppConfiguration("file:src/main/java")
@Transactional
public class BaseDaoTest {
}
