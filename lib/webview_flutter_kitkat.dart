
import 'model/token.dart';
import 'webview_flutter_kitkat_platform_interface.dart';

class WebviewFlutterKitkat {
  Future<void> openWebView({required String link, Token? token}) async {
    await WebviewFlutterKitkatPlatform.instance.openWebView(link: link, token: token);
  }
}
