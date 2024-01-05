package chap10.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// ServletContextListener : 컨텍스트 내부 내용에 변화가 있어 리로드 할 때 호출되는 이벤트 리스너
public class ContextLoaderListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener : 컨텍스트 내부에 수정된 사항이 있었습니다...");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener : 컨텍스트가 파괴되었습니다...");
	}
}
