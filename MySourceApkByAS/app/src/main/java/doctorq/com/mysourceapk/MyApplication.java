package doctorq.com.mysourceapk;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("demo", "source apk onCreate:"+this);
	}

}
