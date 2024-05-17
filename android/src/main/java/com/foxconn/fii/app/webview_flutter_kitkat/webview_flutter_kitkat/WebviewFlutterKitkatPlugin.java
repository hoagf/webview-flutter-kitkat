package com.foxconn.fii.app.webview_flutter_kitkat.webview_flutter_kitkat;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.foxconn.fii.app.webview_flutter_kitkat.webview_flutter_kitkat.model.Token;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** WebviewFlutterKitkatPlugin */
public class WebviewFlutterKitkatPlugin implements FlutterPlugin, ActivityAware, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private Activity activity;


  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "webview_flutter_kitkat");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    switch (call.method){
      case "openWebView":
        Token token = null;
        String link = call.argument("link");
        HashMap<String, Object> tokenStr = call.argument("token");
        Log.d("hhh", "link:"+link);
        Log.d("hhh", "token:"+tokenStr.toString());

        if(tokenStr!=null&&!tokenStr.isEmpty()){
          token = new Gson().fromJson(new Gson().toJson(tokenStr), Token.class);
        }

        Intent intent = new Intent(activity, WebViewActivity.class);
        if(token!=null){
          intent.putExtra("TOKEN", token);
        }
        intent.putExtra("LINK", link);
        activity.startActivity(intent);
        break;
      default:
        result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
    activity = null;
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
    activity = binding.getActivity();
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {
    activity = null;
  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
    activity = binding.getActivity();
  }

  @Override
  public void onDetachedFromActivity() {
    activity = null;
  }
}
