#import <Foundation/Foundation.h>

/*
*日期与时间（NSDate）
*/

int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		//获取当前NSDate
		NSDate * date0=[NSDate date];
		NSLog(@"当前NSDate:%@",date0);

		//获取从现在开始的一天之后的时间
		NSDate * date1=[[NSDate alloc] initWithTimeIntervalSinceNow:3600*24];
		NSLog(@"从现在开始的一天之后的时间:%@",date1);

		//获取从现在开始的三天之前的时间
		NSDate * date2=[[NSDate alloc] initWithTimeIntervalSinceNow:-3*3600*24];
		NSLog(@"从现在开始的一天之后的时间:%@",date2);

		//获取从1970之后的20年日期
		NSDate * date3=[NSDate dateWithTimeIntervalSince1970:3600*24*20*365];
		NSLog(@"从1970之后的20年日期:%@",date3);

		//获取系统当前的Locale
		NSLocale * cn=[NSLocale currentLocale];
		NSLog(@"系统当前的Locale:%@",[date1 descriptionWithLocale:cn]);

		//获取两个日期较早的日期
		NSDate * earlier=[date1 earlierDate:date2];
		NSLog(@"两个日期较早的日期:%@",earlier);

		//获取两个日期较晚的日期
		NSDate * late=[date1 laterDate:date2];
		NSLog(@"两个日期较晚的日期:%@",late);

		//分别代表compare
		switch([date1 compare:date3]){
			case NSOrderedAscending:
			     NSLog(@"之前");
				 break;
			case NSOrderedSame:
				 NSLog(@"相等");
				 break;
			case NSOrderedDescending:
				 NSLog(@"之后");
				 break;
		}

		//获取两个时间之间的时间差
		NSLog(@"两个时间之间的时间差:%g",[date1 timeIntervalSinceDate:date3]);

		//获取指定时间与现在时间的时间差
		NSLog(@"获取指定时间与现在时间的时间差:%g",[date2 timeIntervalSinceNow]);
	}
}