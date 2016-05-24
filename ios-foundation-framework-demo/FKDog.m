#import "FKDog.h"

/*
* NSCopying和NSMutableCopy协议
*/
@implementation FKDog
@synthesize name;
@synthesize age;
@end

//实现copyWithZone方法
- (id) copyWithZone : (NSZone *) zone
{
	NSLog(@"***执行copyWithZone方法**");
	//使用zone参数创建FKDog对象
	FKDog * dog=[[[self class ] allocWithZone:zone] init];
	dog.name=self.name;
	dog.age=self.age;
	return dog;
}