#import "FlutterScreenPlugin.h"
#if __has_include(<flutter_screen/flutter_screen-Swift.h>)
#import <flutter_screen/flutter_screen-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flutter_screen-Swift.h"
#endif

@implementation FlutterScreenPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterScreenPlugin registerWithRegistrar:registrar];
}
@end
