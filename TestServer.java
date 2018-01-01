/* add service
 * read, parse, call, reply
 */

public class TestServer{
	private static final String TAG = "TestServer";

	public static void main(String args[])
	{
		Slog.i(TAG, "add hello service");
        	ServiceManager.addService("hello", new HelloService());
		//ServiceManager.addService(Context.USER_SERVICE, UserManagerService.getInstance());
		while(true)
		{
			Thread.sleep(100);
			// we don't have to do anything because we use app_process to run
			// this app will use binder 1 and 2 to help read and parse the data
		}
	}
}

