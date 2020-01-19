package com.ajanuw.flutter_screen

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar


const val CHANNEL: String = "github.com/januwA/flutter_screen"

/** FlutterScreenPlugin */
@Suppress("DEPRECATION")
public class FlutterScreenPlugin : FlutterPlugin, MethodCallHandler, ActivityAware {
    private lateinit var activity: Activity
    private lateinit var applicationContext: Context
    private lateinit var methodChannel: MethodChannel

    override fun onAttachedToEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        onAttachedToEngine(binding.getApplicationContext(), binding.getBinaryMessenger());
    }

    // 旧的构建方法
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            FlutterScreenPlugin().onAttachedToEngine(registrar.context(), registrar.messenger())
        }
    }

    private fun onAttachedToEngine(context: Context, messenger: BinaryMessenger) {
        applicationContext = context
        methodChannel = MethodChannel(messenger, CHANNEL)
        methodChannel.setMethodCallHandler(this)

    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        if (call.method == "keepOn") {
            val on: Boolean? = call.argument("on");
            if (on == null) {
                result.notImplemented()
            } else {
                if (on) {
                    activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
                } else {
                    activity.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
                }
            }
        } else {
            result.notImplemented()
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        methodChannel.setMethodCallHandler(null);
    }

    override fun onDetachedFromActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        activity = binding.activity
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        activity = binding.activity
    }

    override fun onDetachedFromActivityForConfigChanges() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
