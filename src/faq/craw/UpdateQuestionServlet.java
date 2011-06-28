package faq.craw;

import java.io.IOException;
import java.util.Date;
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
public class UpdateQuestionServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Query query = psm.newQuery(Question.class);
		query.setOrdering("date asc");
		query.setRange(0,5);
		@SuppressWarnings("unchecked")
		List<Question> listTags = (List<Question>) query.execute();
		if(listTags.size() > 0)
		{
			for (int i = 0; i < listTags.size(); i++) {
				listTags.get(i).setDate(new Date());
				psm=JDOHelper.getPersistenceManager(listTags.get(i));
				psm.currentTransaction().begin();
				psm.makePersistent(listTags.get(i));
				psm.currentTransaction().commit();
			}
		}
	}

}
