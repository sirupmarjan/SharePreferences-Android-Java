package com.quick.shrpreference;

import android.os.StrictMode;

public class ModuleTool {
    public void allowNetworkOnMainThread() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
