import 'dart:async';

import 'package:flutter/services.dart';

const String _CHANNEL = "github.com/januwA/flutter_screen";

class FlutterScreen {
  static const MethodChannel _channel = const MethodChannel(_CHANNEL);
  static Future keepOn(bool on) => _channel.invokeMethod('keepOn', {"on": on});
}
