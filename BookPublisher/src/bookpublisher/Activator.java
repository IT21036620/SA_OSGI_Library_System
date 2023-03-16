package bookpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	private ServiceRegistration bookServiceRegister;

	public void start(BundleContext context) throws Exception {
		System.out.println("Books Service Started...");
		BookService bookService = new BookServiceImpl();
		bookServiceRegister = context.registerService(BookService.class.getName(), bookService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Book Service Stopped !!!");
		bookServiceRegister.unregister();
	}

}
