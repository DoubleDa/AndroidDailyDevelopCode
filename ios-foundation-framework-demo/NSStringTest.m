#import <Foundation/Foundation.h>
/*
*创建NSString的三种方法
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool{
		unichar data[6]={12,23,45,67,35,78};
		//1、使用Unicode数值数组初始化字符串
		NSString * str=[[NSString alloc] initWithCharacters: data length:6];
		NSLog(@"%@",str);
		char * cstr="Hello Ios!";
		//2、将C字符串转换为NSString对象
		NSString * str1=[NSString stringWithUTF8String:cstr];
		NSLog(@"%@",str1);
		//3、将字符串写入指定文件
		[str1 writeToFile:@"myFile.txt"
			atomically:YES
			encoding:NSUTF8StringEncoding
			error:nil
			];
		//读取文件内容，将文件内容初始化为字符串
		NSString * str3=[NSString stringWithContentsOfFile:@"NSStringTest.m"
			encoding:NSUTF8StringEncoding
			error:nil
			];
		NSLog(@"%@",str3);
	}
}