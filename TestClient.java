/* getservice
 * use sayhello or sayhello_to
 */

/* test_client <hello|goodbye> [name] */
public class TestClient{
	private static final String TAG = "TestServer";

	public static void main(String args[])
	{
		if(args.length == 0)
		{
			System.out.println("Usage: need parameter: <hello|goodbye> [name]");
			return;
		}

		if(args[0].equals("hello"))
		{
			/*getService*/
			IBinder binder = ServiceManager.getService("hello");
			if(binder == null)
			{
				System.out.println("can't get hello service");
				Slog.i(TAG, "can't get hello service");
				return;
			}
			
			//we need to use sayhello from the IHelloService's proxy
			//hence we need to convert binder into our 

			IHelloService svr = IHelloService.Stub.asInterface(binder);

			if(args.length == 1)
			{		
				svr.sayhello();
				System.out.println("call sayhello");
				Slog.i(TAG, "call sayhello");
			}
			else
			{
				int cnt = svr.sayhello_to(args[1]);
				System.out.println("call sayhello_to "+args[1]+" : cnt = "+cnt);
				Slog.i(TAG, "call sayhello_to "+args[1]+" : cnt = "+cnt);
			}
	
		}
	}
}
