package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.franklin.dataaccess.MediaManagerAdminDAO;
import edu.franklin.model.UserDetail;

public class AdminDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		edu.franklin.dataaccess.MediaManagerAdminDAO dao = new MediaManagerAdminDAO("jdbc:mysql://localhost:3306/mediamanager", "root", "");
		UserDetail ud = dao.authenticateUser("jrenkel", "password");
		assertNotNull(ud);
		assertEquals(1,ud.getId());
		assertEquals("jrenkel",ud.getUserName());
		assertEquals("password",ud.getPassword());
	}

}
