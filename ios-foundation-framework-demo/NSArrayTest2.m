#import <Foundation/Foundation.h>
#import "FKUser.h"

int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		NSArray * array=[NSArray arrayWithObjects:
			[[FKUser alloc] initWithName:@"aaa" pass:@"111"],
			[[FKUser alloc] initWithName:@"bbb" pass:@"222"],
			[[FKUser alloc] initWithName:@"ccc" pass:@"333"],
			[[FKUser alloc] initWithName:@"ddd" pass:@"444"],
			[[FKUser alloc] initWithName:@"eee" pass:@"555"],
			nil];
		//查找指定元素在数组中的索引
		FKUser * newUser=[[FKUser alloc] initWithName:@"bbb" pass:@"222"];
		NSUInteger pos=[array indexOfObject:newUser];
		NSLog(@"指定元素在新数组中的位置：%ld",pos);
	}
}