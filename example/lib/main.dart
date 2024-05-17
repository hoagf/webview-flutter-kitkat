import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:webview_flutter_kitkat/model/token.dart';
import 'package:webview_flutter_kitkat/webview_flutter_kitkat.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';
  final _webviewFlutterKitkatPlugin = WebviewFlutterKitkat();

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    WebviewFlutterKitkat flutterKitkat = WebviewFlutterKitkat();
    Token token = Token(accessToken: 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTU5OTgwNjcsInVzZXJfbmFtZSI6IlYxMDM1NzkzIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9PQVVUSF9VU0VSIl0sImp0aSI6ImM1NDY5MmQ5LTMzNDItNDM0Yi04YmE5LTYxZTYwNTM0ZDA4MyIsImNsaWVudF9pZCI6IndzLXN5c3RlbSIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.a7zcBma9bNiZhxwMYxIX9ZwNF0sxUjdSpB6Palu41Tz2lIjWXAWX-IVsQ2iH8hbWXo_qjrEvcVObhO0_i8JRMASIYlyRVoHmuOXQ2wkTHKV17VKRzqTbOtrk77pHokQzpRG9mhrWOOIxzdAtLLgQwTyQh-euQBSQ6lYA-iLwG33ns9FrJHlDbM-s-RY9eSjfihFtC4ayROObOvA5MjOoMpjafCt_0BPmcYP0mzAOEGCYO7Qfq1J1a75IYjcwalsVgAssTdzsaf18kqHTPI1yjXtBcAkXyrkSVIkiaJ7d79qGj-VGMjetbOFo2aHbxOYFpX7xkn4iSrwxoBVhzX3kcg',
    tokenType: 'bearer',
    refreshToken: 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJWMTAzNTc5MyIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJhdGkiOiJjNTQ2OTJkOS0zMzQyLTQzNGItOGJhOS02MWU2MDUzNGQwODMiLCJleHAiOjE3MTg1MDM2NjcsImF1dGhvcml0aWVzIjpbIlJPTEVfT0FVVEhfVVNFUiJdLCJqdGkiOiJlYzFkZTgwYi1hN2U5LTRkMGItODVkNy1lYzRlMWI0ODczOWEiLCJjbGllbnRfaWQiOiJ3cy1zeXN0ZW0ifQ.e7fpDOpE4ORg2gAWb1yZZtv7q_RYXCQLTlcTP3xx4QcHOezyuxq0nhpxNhCNsdEoL8-gz6zuhelj60tPFBFFxQKItNd-3OlJnJuJ8CxCu7ocoz0dMcDxwuIElKJ4w372Psxmrkz2KmYQ7kBcoJ8vLRSrmX_b_UWymyj06l5SIzQM1phivuBsYzxUx_XfoNcBmkpIk1OZ76PrOHALndzwcuglnamtGTOXEHZrx4vbN1qniOgFqVcLmya6pew2FlKyPbqPa-tNMeihXOrXqfXMqogpb2i8fC7LE66uM5pdEn1unNzM2JfIrK-8drsf7TT6HPOs87FGI4aB7vDGOZm3Qg',
    expiresIn: 86399,
    jti: 'c54692d9-3342-434b-8ba9-61e60534d083',
    scope: 'read write');
    flutterKitkat.openWebView(link: 'https://fiisw.cnsbg.efoxconn.com:6443/peachat/home', token: token);
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_platformVersion\n'),
        ),
      ),
    );
  }
}
