package io.sichacvah.react.headless;


import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.content.Intent;
import com.facebook.react.bridge.ReadableMap;
import android.os.Bundle;

public class HeadlessModule extends ReactContextBaseJavaModule {
  private final static String LOG_TAG = HeadlessModule.class.getCanonicalName();

  public HeadlessModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "HeadlessModule";
  }

  @ReactMethod
  public void runTask(String taskKey, ReadableMap args, float timeout, boolean allowedInForeground) {
    ReactApplicationContext reactContext = getReactApplicationContext();
    Intent service = new Intent(reactContext, HeadlessService.class);
    service.putExtra("allowedInForeground", allowedInForeground);
    Bundle bundle = Arguments.toBundle(args);
    service.putExtra("args", bundle);
    service.putExtra("timeout", timeout);
    service.putExtra("taskKey", taskKey);
    reactContext.startService(service);
  }
}
