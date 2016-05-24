#import <Foundation/Foundation.h>
/*
*NSMutableString 可变字符串
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		NSString * book=@"《疯狂ios讲义》";
		//创建NSMutableString对象
		NSMutableString * str=[NSMutableString stringWithString:@"Hello"];

		//追加固定字符串
		[str appendString:@" ios!"];
		NSLog(@"%@",str);

		//追加带变量的字符串
		[str appendFormat:@"%@是一本很不错的iOS学习书籍！",book];
		NSLog(@"%@",str);

		//在指定位置插入字符串
		[str insertString:@"dayongxin.com" atIndex:10];
		NSLog(@"%@",str);

		//删除从位置6到15得到字符串
		[str deleteCharactersInRange:NSMakeRange(6,15)];
		NSLog(@"%@",str);

		//将位置6到10的字符串替换为“Android”
		[str replaceCharactersInRange:NSMakeRange(6,10) withString:@"Android"];
		NSLog(@"%@",str);
	}
}