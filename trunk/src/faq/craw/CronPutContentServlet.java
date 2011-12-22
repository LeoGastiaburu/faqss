package faq.craw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.data.QnAPersistenceManager;
import faq.model.Question;

@SuppressWarnings("serial")
public class CronPutContentServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Query query = psm.newQuery(Question.class);
		query.setFilter("twentyTitle==null");
		query.setRange(0,10);
		@SuppressWarnings("unchecked")
		List<Question> list = (List<Question>) query.execute();
		if(list.size() > 0)
		{
			for (int i = 0; i < list.size(); i++) {
				
				list.get(i).setTwentyTitle("yes");
				psm=JDOHelper.getPersistenceManager(list.get(i));
				psm.currentTransaction().begin();
				psm.makePersistent(list.get(i));
				psm.currentTransaction().commit();
				try {
		            URL url = new URL("http://gardenquestions.com/import/?url="+list.get(i).getUrl());
		            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		        } catch (MalformedURLException e) {
		            // ...
		        } catch (IOException e) {
		            // ...
		        }
			}
		}
	}
}
