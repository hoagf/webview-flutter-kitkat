import 'package:plugin_platform_interface/plugin_platform_interface.dart';
import 'package:webview_flutter_kitkat/model/token.dart';

import 'webview_flutter_kitkat_method_channel.dart';

abstract class WebviewFlutterKitkatPlatform extends PlatformInterface {
  /// Constructs a WebviewFlutterKitkatPlatform.
  WebviewFlutterKitkatPlatform() : super(token: _token);

  static final Object _token = Object();

  static WebviewFlutterKitkatPlatform _instance = MethodChannelWebviewFlutterKitkat();

  /// The default instance of [WebviewFlutterKitkatPlatform] to use.
  ///
  /// Defaults to [MethodChannelWebviewFlutterKitkat].
  static WebviewFlutterKitkatPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [WebviewFlutterKitkatPlatform] when
  /// they register themselves.
  static set instance(WebviewFlutterKitkatPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<void> openWebView({required String link, Token? token}) {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
