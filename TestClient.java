/* getservice
 * use sayhello or sayhello_to
 */
import android.util.Slog;
import android.os.ServiceManager;
import android.os.IBinder;

/* test_client <hello|goodbye> [name] */
public class TestClient{
	private static final String TAG = "TestClient";

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
			{	try{
					svr.sayhello();
					System.out.println("call sayhello");
					Slog.i(TAG, "call sayhello");
				}catch(Exception e){}
			}
			else
			{
				try{
					int cnt = svr.sayhello_to(args[1]);
					System.out.println("call sayhello_to "+args[1]+" : cnt = "+cnt);
					Slog.i(TAG, "call sayhello_to "+args[1]+" : cnt = "+cnt);
				}catch(Exception e){}
			}
	
		}
	}
}
