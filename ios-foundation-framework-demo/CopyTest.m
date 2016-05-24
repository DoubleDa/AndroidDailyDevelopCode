#import <Foundation/Foundation.h>

/*
*对象复制：copy和mutableCopy方法
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		//创建对象
		NSMutableString * book=[NSMutableString stringWithString:@"我喜欢《疯狂iOS讲义》这本书！"];
		//复制book字符串的可变字符串
		NSMutableString * copyBook=[book mutableCopy];
		//修改副本，对愿字符串没有影响
		[copyBook replaceCharactersInRange:NSMakeRange(6,7) withString:@"Android"];
		//打印愿字符串
		NSLog(@"愿字符串%@",book);
		//打印字符串副本
		NSLog(@"字符串副本:%@",copyBook);
		NSString * str=@"dayongxin";
		//复制str为可变副本
		NSMutableString * copyStr=[str mutableCopy];
		//追加字符串
		[copyStr appendString:@".com"];
		//打印
		NSLog(@"复制str为可变副本:%@",copyStr);
		//不可变字符串
		NSMutableString * book2=[book copy];
		[book2 appendString:@".org"];
		NSLog(@"%@",book2);
	}
}