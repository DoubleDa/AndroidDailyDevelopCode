#import <Foundation/Foundation.h>

@interface FKUser : NSObject
@property (nonatomic,copy) NSString* name;
@property (nonatomic,copy) NSString* pass;

- (id) initWithName:(NSString*) aName
{
	pass:(NSString*) aPass;
}

- (void) say:(NSString*) content;
@end