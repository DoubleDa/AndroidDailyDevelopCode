#import <Foundation/Foundation.h>
@synthesize count;
/*
*定时器（NSTimer）
*/
int main(int argc, char const *argv[])
{
	//启动一个定时器
	[NSTimer scheduleTimeWithTimeInterval:0.5
		target:self
		selector:@selector(info:)
		userInfo:nil
		repeats:YES];
}

//info:方法
- (void) info:(NSTimer *) timer
{
	NSLog(@"正在执行%d次任务",self.count++);
	if(self.count>10)
	{
		NSLog(@"取消定时器");
		[timer invalidate];
	}
}