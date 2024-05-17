//package com.foxconn.fii.app.webview_flutter_kitkat.webview_flutter_kitkat;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.app.ProgressDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.net.http.SslError;
//import android.util.Log;
//import android.webkit.CookieManager;
//import android.webkit.CookieSyncManager;
//import android.webkit.SslErrorHandler;
//import android.webkit.ValueCallback;
//import android.webkit.WebResourceError;
//import android.webkit.WebResourceRequest;
//import android.webkit.WebResourceResponse;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.Toast;
//
//public class MyWebViewClient extends WebViewClient {
//
//    Activity activity;
//    static int check=0;
//    public MyWebViewClient(Activity activity) {
//        this.activity = activity;
//    }
//
//    @SuppressLint("ResourceType")
//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        Log.d("TAGSplash", "Webview" + url);
//        if (url.startsWith(Constants.URL + "peachat/sign-in")) {
//            Log.d("TAGSplash", "Webview");
//            Intent intents = new Intent(activity, MyService.class);
//            intents.setAction(MyService.ACTION_STOP_FOREGROUND_SERVICE);
//            activity.startService(intents);
//            Intent intent = new Intent();
//            intent.setClass(activity, LoginActivity.class);
//            activity.startActivity(intent);
//            activity.finish();
//            MySharePref.getInstance().put("REMEMBER_PASS", false);
//        } else if (url.startsWith("intent://")) {
//            view.stopLoading();
//            PackageManager pm = activity.getPackageManager();
//            Intent launchIntent = pm.getLaunchIntentForPackage("cn.com.iccnconn");
//            if (launchIntent != null) {
//                activity.startActivity(launchIntent);
//            } else {
////                Toast.makeText(activity, "Package not found", Toast.LENGTH_SHORT).show();
//                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//                builder.setIcon(activity.getResources().getDrawable(R.drawable.pc));
//                builder.setTitle("You don't install. Do you want install app ICC?");
//                builder.setCancelable(true);
//
//                builder.setPositiveButton(
//                        "Yes",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                Intent intent = new Intent(Intent.ACTION_VIEW);
//                                String url = "http://14.238.8.142:6152/fiistore/ws-data/images/TDB/ICC.apk";
//                                intent.setData(Uri.parse(url));
//                                activity.startActivity(intent);
//                            }
//                        });
//
//                builder.setNegativeButton(
//                        "No",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//
//                AlertDialog alert = builder.create();
//                alert.show();
//            }
//        } else if (url.contains(Constants.URL + "hr-system/403-error-page")&&check==0) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//            builder.setTitle("Cảnh báo");
//            builder.setMessage("You don't have permission to access this system.");
//            builder.setCancelable(false);
//            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    hideLoadingDialog();
//                    activity.onBackPressed();
//                }
//            });
//            builder.show();
//        } else if (url.equals(Constants.URL + "hr-system")||url.equals(Constants.URL_OAUTHS + "hr-system")) {
//            hideLoadingDialog();
//            activity.startActivity(new Intent(activity, MainActivity.class));
//            activity.finish();
//        } else {
//            view.loadUrl(url);
//        }
//        return false;
//    }
//
//    @Override
//    public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
//        handler.proceed();
//    }
//
//    @SuppressLint("NewApi")
//    @Override
//    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//        Log.d("TAG123", "onReceivedError: " + error.getDescription().toString() + "\n" + error.getErrorCode());
//        super.onReceivedError(view, request, error);
//    }
//
//    @SuppressLint("NewApi")
//    @Override
//    public void onReceivedHttpError(final WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
//        Log.d("TAG123", "onReceivedHttpError: " + request.getUrl() + "\n" + errorResponse.getReasonPhrase().toString() + "\n" + errorResponse.getStatusCode());
//        if (view.getUrl().equals(Constants.URL + "http://14.238.8.142:6152/hr-system/cw-home")) {
//            if (errorResponse.getStatusCode() == 404) {
//                Toast.makeText(activity, "Have ERROR", Toast.LENGTH_SHORT).show();
//                CookieSyncManager.createInstance(activity);
//                CookieManager cookieManager = CookieManager.getInstance();
//                cookieManager.removeSessionCookie();
//            }
//        }
//
//        super.onReceivedHttpError(view, request, errorResponse);
//    }
//
//    @Override
//    public void onPageStarted(WebView view, String url, Bitmap favicon) {
//        if (view.getUrl().equals(Constants.URL + "hr-system/cw-home"))
//            check=0;
//        else if(view.getUrl().equals(Constants.URL + "hr-system/oppm"))
//            check=1;
////        if(!view.getUrl().equals(Constants.URL +"hr-system/")&&!view.getUrl().equals(Constants.URL_OAUTHS +"hr-system/"))
////            showLoadingDialog(false);
//        Log.d("TAGSplash", "start: " + url);
//        super.onPageStarted(view, url, favicon);
//    }
//
//    @Override
//    public void onPageFinished(WebView view, String url) {
//        if (url.equals(Constants.URL + "peachat/home#/in-chat"))
//            MySharePref.getInstance().put("InChat", true);
//        else
//            MySharePref.getInstance().put("InChat", false);
////        hideLoadingDialog();
//        Log.d("TAGSplash", "finish: " + url);
//        Intent intent = new Intent();
//        if (url.equals(Constants.URL + "peachat/logout")) {
//            Intent intents = new Intent(activity, MyService.class);
//            intents.setAction(MyService.ACTION_STOP_FOREGROUND_SERVICE);
//            activity.startService(intents);
//            intent.setClass(activity, LoginActivity.class);
//            activity.startActivity(intent);
//            MySharePref.getInstance().put("REMEMBER_PASS", false);
//        } else if (url.equals(Constants.URL + "peachat/home#/smart-factory")) {
//            activity.startActivity(new Intent(activity, MainActivity.class));
//            activity.finish();
//        } else if (url.equals(Constants.URL + "peachat/home#/hrpm/myTeam")) {
//            intent.setClass(activity, MainActivity.class);
//            intent.setAction("MyTeam");
//            activity.startActivity(intent);
//        }
//        view.evaluateJavascript(
//                "javascript:(function() {\n" +
//                        "var local = JSON.parse(window.localStorage.getItem('pea-data'));\n" +
//                        "if (local == null) {\n" +
//                        "\tlocal = {};\n" +
//                        "}\n" +
//                        "local.uuid = '" + Utils.getUUID(activity) + "';\n" +
//                        "window.localStorage.setItem('pea-data', JSON.stringify(local));\n" +
//                        "})();"
//                , new ValueCallback<String>() {
//                    @Override
//                    public void onReceiveValue(String s) {
//                        Log.d("TAG1111", "start: " + s);
//                    }
//                });
//        super.onPageFinished(view, url);
//    }
//
//    private ProgressDialog progressDialog;
//
//    public void showLoadingDialog(boolean hasCancel) {
//        if (progressDialog == null) {
//            progressDialog = new ProgressDialog(activity);
//            progressDialog.setIndeterminate(true);
//            progressDialog.setCancelable(hasCancel);
//            progressDialog.setMessage(activity.getResources().getString(R.string.loading));
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        }
//        if (!progressDialog.isShowing()) {
//            try {
//                progressDialog.show();
//            } catch (Exception ex) {
//            }
//        }
//    }
//
//    public void hideLoadingDialog() {
//        if (progressDialog != null && progressDialog.isShowing()) {
//            progressDialog.dismiss();
//        }
//    }
//
//    @Override
//    public void onLoadResource(WebView view, String url) {
//        Log.d("1111", "onLoadResource: "+url);
//        super.onLoadResource(view, url);
//    }
//}