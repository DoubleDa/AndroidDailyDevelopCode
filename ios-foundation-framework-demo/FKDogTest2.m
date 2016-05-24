#import <Foundation/Foundation.h>
#import "FKDog.h"

/*
* 浅复制（shallow copy）与深复制（deep copy）
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		//创建FKDog对象
		FKDog * dog=[FKDog new];
		//给对象属性赋值
		dog.name=[NSMutableString stringWithString:@"哒哒"];
		dog.age=20;
		//复制副本
		FKDog * dog1=[dog copy];
		//修改dog1的name属性
		[dog1.name replaceCharactersInRange:NSMakeRange(0,2) withString:@"dayongxin"];
		//打印信息
		NSLog(@"dog属性%@",dog.name);
		NSLog(@"dog1属性%@",dog1.name);
	}
}