import 'package:flutter/material.dart';
import 'package:flutter_screen/flutter_screen.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              RaisedButton(
                child: Text('keep'),
                onPressed: () {
                  FlutterScreen.keepOn(true);
                },
              ),
              SizedBox(width: 12),
              RaisedButton(
                child: Text('not keep'),
                onPressed: () {
                  FlutterScreen.keepOn(false);
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}
