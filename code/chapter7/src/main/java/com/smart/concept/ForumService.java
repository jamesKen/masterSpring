package com.smart.concept;

public class ForumService {
	private PerformanceMonitor pmonitor;
	private TransactionManager transManager;
	private TopicDao topicDao;
	private ForumDao forumDao;

	public void removeTopic(int topicId) {
		pmonitor.strart();
		transManager.beginTransaction();
		topicDao.removeTopic(topicId);
		transManager.commit();
		pmonitor.end();
	}

	public void createForum(Forum forum) {
		pmonitor.strart();
		transManager.beginTransaction();
		forumDao.create(forum);
		transManager.commit();
		pmonitor.end();
	}
}
