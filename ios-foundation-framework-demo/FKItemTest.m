#import <Foundation/Foundation.h>
#import "FKItem.h"

/*
* setter方法的复制选项
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		//创建FKItem对象
		FKItem * item=[FKItem new];
		//赋值
		item.name=[NSMutableString stringWithString:@"疯狂iOS讲义"];
		//追加字符串
		[item.name appendString:@"dayongxin.com"];
		NSLog(@"名字:%@",item.name);
	}
}