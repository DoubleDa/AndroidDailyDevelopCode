#import <Foundation/Foundation.h>

/*
*日历（NSCalendar）和日期组件（NSDateComponents）
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		//获取代表公历的Calendar对象
		NSCalendar * cal=[[NSCalendar alloc] initWithCalendarIdentifier:NSCalendarIdentifierGregorian];
		//获取当前日期
		NSDate * dt=[NSDate date];
		//定义一个时间段的游标
		unsigned unitFlag=NSCalendarUnitYear | NSCalendarUnitMonth | NSCalendarUnitDay | NSCalendarUnitHour | NSCalendarUnitMinute | NSCalendarUnitSecond |NSCalendarUnitWeekday;
		//获取不同的时间字段信息
		NSDateComponents * dc=[cal components : unitFlag fromDate:dt];
		//获取个时间段信息
		NSLog(@"%ld年",dc.year);
		NSLog(@"%ld月",dc.month);
		NSLog(@"%ld日",dc.day);
		NSLog(@"%ld时",dc.hour);
		NSLog(@"%ld分",dc.minute);
		NSLog(@"%ld秒",dc.second);
		NSLog(@"%ld周末",dc.weekday);

		//创建NSDateComponents对象
		NSDateComponents * dc2=[[NSDateComponents alloc] init];
		//设置个时间段的数值
		dc2.year=2015;
		dc2.month=6;
		dc2.day=7;
		dc2.hour=13;
		dc2.minute=34;
		dc2.second=56;
		dc2.weekday=4;
		NSDate * dt2=[cal dateFromComponents:dc2];
		NSLog(@"获取的当前日期为:%@",dt2);
	}
}