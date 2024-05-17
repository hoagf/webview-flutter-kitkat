import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';
import 'package:webview_flutter_kitkat/model/token.dart';

import 'webview_flutter_kitkat_platform_interface.dart';

/// An implementation of [WebviewFlutterKitkatPlatform] that uses method channels.
class MethodChannelWebviewFlutterKitkat extends WebviewFlutterKitkatPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('webview_flutter_kitkat');

  @override
  Future<void> openWebView({required String link, Token? token}) async {
    await methodChannel.invokeMethod<void>('openWebView', {'link':link, 'token':token?.toJson()});
  }
}
