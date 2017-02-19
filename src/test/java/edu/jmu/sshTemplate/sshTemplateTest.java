package edu.jmu.sshTemplate;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class sshTemplateTest {

	@Before
	public void setUp() throws Exception {
		// String xmlPath = "applicationContext.xml";
		// ApplicationContext ac = new ClassPathXmlApplicationContext(xmlPath);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		LogManager.getRootLogger().debug("TEST LogDebug");
		LogManager.getRootLogger().info("TEST LogInfo");
		LogManager.getRootLogger().warn("TEST LogWarn");
		LogManager.getRootLogger().error("TEST LogError");
		Assert.assertTrue(true);
	}

}
