#import <Foundation/Foundation.h>
/*
*NSDateFormatter（日期格式器）
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		//获取从1970年开始20年到现在的日期
		NSDate *dt=[NSDate dateWithTimeIntervalSince1970:3600*24*366*20];

		//创建两个NSLocale
		NSLocale * locales[]={[[NSLocale alloc] initWithLocaleIdentifier:@"zh_CN"]
		,[[NSLocale alloc] initWithLocaleIdentifier:@"en_US"]};

		//创建NSDateFormatter对象
		NSDateFormatter * df[8];

		//为两个locales创建8个NSDateFormatter对象
		for (int i = 0; i < 2; i++)
		{
			df[i*4]=[[NSDateFormatter alloc] init];

			//设置NSDateFormatter日期、时间风格
			[df[i*4] setDateStyle:NSDateFormatterShortStyle];
			[df[i*4] setTimeStyle:NSDateFormatterShortStyle];

			//设置NSDateFormatter的NSLocale
			[df[i*4] setLocale:locales[i]];
			df[i*4+1]=[[NSDateFormatter alloc] init];

			//设置NSDateFormatter日期、时间风格
			[df[i*4+1] setDateStyle:NSDateFormatterMediumStyle];
			[df[i*4+1] setTimeStyle:NSDateFormatterMediumStyle];

			//设置NSDateFormatter的NSLocale
			[df[i*4+1] setLocale:locales[i]];
			df[i*4+2]=[[NSDateFormatter alloc] init];

			//设置NSDateFormatter日期、时间风格
			[df[i*4+2] setDateStyle:NSDateFormatterLongStyle];
			[df[i*4+2] setTimeStyle:NSDateFormatterLongStyle];

			//设置NSDateFormatter的NSLocale
			[df[i*4+2] setLocale:locales[i]];
			df[i*4+3]=[[NSDateFormatter alloc] init];

			//设置NSDateFormatter日期、时间风格
			[df[i*4+3] setDateStyle:NSDateFormatterFullStyle];
			[df[i*4+3] setTimeStyle:NSDateFormatterFullStyle];

			//设置NSDateFormatter的NSLocale
			[df[i*4+3] setLocale:locales[i]];
		}

		for (int i = 0; i < 2; i++)
		{
			switch(i){
				case 0:
				NSLog(@"***中国日期***");
				break;
				case 1:
				NSLog(@"***美国日期***");
				break;
			}
			NSLog(@"Short格式的日期格式:%@",[df[i*4] stringFromDate:dt]);
			NSLog(@"Medium格式的日期格式:%@",[df[i*4+1] stringFromDate:dt]);
			NSLog(@"Long格式的日期格式:%@",[df[i*4+2] stringFromDate:dt]);
			NSLog(@"Full格式的日期格式:%@",[df[i*4+3] stringFromDate:dt]);
		}

		//创建NSDateFormatter对象
		NSDateFormatter * df2=[[NSDateFormatter alloc] init];
		//设置自定义的格式器模板
		[df2 setDateFormat:@"yyyy-MM-DD HH-mm"];
		//执行格式化
		NSLog(@"%@",[df2 stringFromDate:dt]);

		NSString * dateStr=@"2016-05-23";

		//创建NSDateFormatter对象
		NSDateFormatter * df3=[[NSDateFormatter alloc] init];	
		[df3 setDateFormat:@"yyyy-MM-DD"];

		//将字符串转换为NSDate对象
		NSDate * date2=[df3 dateFromString:dateStr];	
		NSLog(@"%@",date2);
	}
}