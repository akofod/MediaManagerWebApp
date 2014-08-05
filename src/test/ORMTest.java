package test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import edu.franklin.model.Genre;
import edu.franklin.model.MediaItem;
import edu.franklin.model.MediaManagerDAO;
import edu.franklin.model.MediaType;
import edu.franklin.model.PurchaseInfo;

public class ORMTest {

	@Test
	public void testGetUpdate() throws InvocationTargetException {
		MediaItem g = new MediaItem();
		g.setId(1);
		g.setComments("comment");
		g.setCurVal(12.34);
		g.setGenreId(1);
		g.setMediaTypeId(1);
		g.setName("name");
		g.setYear(2010);
		try {
			assertEquals(
					"UPDATE MediaItem SET Name='name',Year=2010,MediaTypeId=1,CurrentValue=12.34,GenreId=1,Comments='comment' WHERE ID=1;",
					g.getUpdate());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGenre() throws InvocationTargetException {
		Genre g = new Genre();
		g.setGenreDesc("techno");
		try {
			assertEquals(
					"INSERT INTO Genre(GenreDescription) VALUES('techno');",
					g.getInsert());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testMediaType() throws InvocationTargetException {
		MediaType g = new MediaType();
		g.setMediaType("DVD");
		try {
			assertEquals(
					"INSERT INTO MediaType(MediaTypeDescription) VALUES('DVD');",
					g.getInsert());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testPurchaseInfo() throws InvocationTargetException {
		PurchaseInfo g = new PurchaseInfo();
		g.setPurLoc("DVD");
		try {
			assertEquals(
					"INSERT INTO PurchaseInfo(PurchaseLocation) VALUES('DVD');",
					g.getInsert());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testMediaItem() throws InvocationTargetException {
		MediaItem g = new MediaItem();
		g.setComments("comment");
		g.setCurVal(12.34);
		g.setGenreId(1);
		g.setMediaTypeId(1);
		g.setName("name");
		g.setYear(2010);
		try {
			assertEquals(
					"INSERT INTO mediaitem(Name,MediaTypeId,Year,CurrentValue,GenreId,Comments) VALUES('name',1,2010,12.34,1,'comment');",
					g.getInsert());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testInsertUpdateGenre() throws SQLException {
		Genre g = new Genre();
		// g.setGenreDesc("Jungle");
		MediaManagerDAO dao = new MediaManagerDAO(
				"jdbc:mysql://localhost:3306/mediamanager", "root", "");
		try {
			int id = dao.addItem(g);
			assertTrue(id > 0);
			g.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		g.setGenreDesc(g.getGenreDesc() + "(DnB)");
		dao.updateItem(g);
	}

	@Test
	public void testInsertMediaType() {
		MediaType g = new MediaType();
		g.setMediaType("DVD");
		MediaManagerDAO dao = new MediaManagerDAO(
				"jdbc:mysql://localhost:3306/mediamanager", "root", "");
		try {
			int id = dao.addItem(g);
			assertTrue(id > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInsertPurchaseInfo() {
		PurchaseInfo g = new PurchaseInfo();
		g.setPurLoc("Amazon");
		MediaManagerDAO dao = new MediaManagerDAO(
				"jdbc:mysql://localhost:3306/mediamanager", "root", "");
		try {
			int id = dao.addItem(g);
			assertTrue(id > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testInsertMediaItem() {
		MediaItem g = new MediaItem();
		g.setComments("comment");
		g.setCurVal(12.34);
		g.setGenreId(1);
		g.setMediaTypeId(1);
		g.setName("name");
		g.setYear(2010);
		MediaManagerDAO dao = new MediaManagerDAO(
				"jdbc:mysql://localhost:3306/mediamanager", "root", "");
		try {
			int id = dao.addItem(g);
			assertTrue(id > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetMediaItems() {
		MediaManagerDAO dao = new MediaManagerDAO(
				"jdbc:mysql://localhost:3306/mediamanager", "root", "");
		try {
			ArrayList<MediaItem> miList = dao.getMediaItems();
			assertEquals(2, miList.size());
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}