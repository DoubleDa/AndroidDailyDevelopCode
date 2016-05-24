#import <Foundation/Foundation.h>
#import "FKDog.h"
/*
* NSCopying和NSMutableCopy协议
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		//创建FKDog对象
		FKDog * fkd=[FKDog new];
		//添加属性
		fkd.name=[NSMutableString stringWithString:@"哒哒"];
		fkd.age=18;
		//复制副本
		FKDog * fkd1=[fkd copy];
		fkd1.name=[NSMutableString stringWithString:@"dayongxin"];
		fkd1.age=20;
		NSLog(@"原始FKDog对象:%@",fkd.name);
		NSLog(@"原始FKDog对象:%d",fkd.age);
		NSLog(@"复制之后的FKDog对象:%@",fkd1.name);
		NSLog(@"复制之后的FKDog对象:%d",fkd1.age);
	}
}