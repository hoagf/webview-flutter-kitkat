import 'package:flutter_test/flutter_test.dart';
import 'package:webview_flutter_kitkat/webview_flutter_kitkat.dart';
import 'package:webview_flutter_kitkat/webview_flutter_kitkat_platform_interface.dart';
import 'package:webview_flutter_kitkat/webview_flutter_kitkat_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockWebviewFlutterKitkatPlatform
    with MockPlatformInterfaceMixin
    implements WebviewFlutterKitkatPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final WebviewFlutterKitkatPlatform initialPlatform = WebviewFlutterKitkatPlatform.instance;

  test('$MethodChannelWebviewFlutterKitkat is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelWebviewFlutterKitkat>());
  });

  test('getPlatformVersion', () async {
    WebviewFlutterKitkat webviewFlutterKitkatPlugin = WebviewFlutterKitkat();
    MockWebviewFlutterKitkatPlatform fakePlatform = MockWebviewFlutterKitkatPlatform();
    WebviewFlutterKitkatPlatform.instance = fakePlatform;

    expect(await webviewFlutterKitkatPlugin.getPlatformVersion(), '42');
  });
}
