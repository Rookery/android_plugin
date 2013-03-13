package aexp.resplugin1;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.Map;
import java.util.HashMap;
import aexp.resplugin.IResPlugin;

public class ResPluginService1 extends Service {
	static final String LOG_TAG = "ResPluginService1";

	public void onStart(Intent intent, int startId) {
		super.onStart( intent, startId );
	}

	public void onDestroy() {
		super.onDestroy();
	}

	public IBinder onBind(Intent intent) {
      	return binder;
	}

    private final IResPlugin.Stub binder = 
			new IResPlugin.Stub() {

		public Bundle onClick(int id, Bundle state) throws RemoteException {
            Log.d( LOG_TAG, "onClick: "+Integer.toHexString( id )+"; state: "+state );
			Bundle update = null;
			if( id == R.id.bt_text ) {
				String o = state.getString( Integer.toString( R.id.et_text ) );
				if( o != null ) {
					Log.d( LOG_TAG, "state: "+o );
					update = new Bundle();
					update.putString( Integer.toString( R.id.tv_text ), o );
				}
			}
			Log.d( LOG_TAG, "update: "+update );
			return update;
		}
    };
}

