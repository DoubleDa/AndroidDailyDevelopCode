#import <Foundation/Foundation.h>
/*
*NSString的常用功能
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		NSString * str1=@"Hello";
		NSString * book=@"疯狂ios讲义";
		//1、追加字符串
		str1=[str1 stringByAppendingString:@" Ios!"];
		NSLog(@"%@",str1);

		//2、获取字符串对应的C风格字符串
		const char * cstr=[str1 UTF8String];
		NSLog(@"获取C语言风格的字符串:%s",cstr);

		//3、在str后面追加带变量的字符串
		str1=[str1 stringByAppendingFormat:@"%@是一本不错的书！",book];
		NSLog(@"%@",str1);

		//4、字符长度
		NSLog(@"str1字符个数为：%lu",[str1 length]);

		//5、字符按utf－8解码之后的字节数
		NSLog(@"str1按utf－8解码之后的字节数:%lu",[str1 lengthOfBytesUsingEncoding:NSUTF8StringEncoding]);

		//6、获取str1的前10个字符组成字符串
		NSString * str2=[str1 substringToIndex:10];
		NSLog(@"%@",str2);

		//7、获取str1第5个字符开始，组成的字符串
		NSString * str3=[str1 substringFromIndex:5];
		NSLog(@"%@",str3);

		//8、获取str1从第5个开始到第15个字符组成的字符串
		NSString * str4=[str1 substringWithRange:NSMakeRange(5,15)];
		NSLog(@"%@",str4);

		//9、获取Ios在字符串中的位置
		NSRange pos=[str1 rangeOfString:@"Ios"];
		NSLog(@"字符串'Ios'在字符串str1的开始位置:%ld,长度为:%ld",pos.location,pos.length);

		//10、将str1转换为大写
		str1=[str1 uppercaseString];
		NSLog(@"%@",str1);
	}
}