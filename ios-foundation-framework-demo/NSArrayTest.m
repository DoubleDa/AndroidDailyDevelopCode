#import <Foundation/Foundation.h>

/*
* NSArray的功能与用法
*/
int main(int argc, char const *argv[])
{
	@autoreleasepool
	{
		//创建NSArray
		NSArray * array=[NSArray arrayWithObjects:
			@"疯狂iOS讲义",@"疯狂swift讲义",@"疯狂Android讲义",@"疯狂Java 讲义",@"疯狂Javascript讲义",nil];
		//打印元素信息
		NSLog(@"索引位置为1的元素:%@",[array objectAtIndex:1]);
		NSLog(@"最后一个元素:%@",[array lastObject]);

		//将索引为1-3之间的元素取出组成新的集合
		NSArray * array1=[array objectsAtIndexes:[NSIndexSet indexSetWithIndexesInRange:NSMakeRange(1,3)]];
		NSLog(@"打印新数组:%@",array1);

		//获取元素在集合中的位置
		NSLog(@"《疯狂Android讲义》在集合中的位置:%ld",[array indexOfObject:@"疯狂Android讲义"]);

		//获取元素在集合指定范围中的位置
		NSLog(@"在1-3范围《疯狂Android讲义》位置：%ld",[array indexOfObject:@"疯狂Android讲义" inRange:NSMakeRange(1,3)]);
		//向数组的最后添加一个元素
		array=[array arrayByAddingObject:@"哒哒"];
		//向数组的最后追加另一个数组的元素
		array=[array arrayByAddingObjectsFromArray:[NSArray arrayWithObjects:@"Go语言",@"C＃",nil]];
		//遍历数组
		for (int i = 0; i < array.count; i++)
		{
			//写法一
			NSLog(@"遍历数组：%@",[array objectAtIndex:i]);
			//写法二：简写
			//NSLog(@"遍历数组：%@",array[i]);
		}

		//获取数组索引为3-6的元素
		NSArray * array2=[array subarrayWithRange:NSMakeRange(5,3)];
		NSLog(@"数组2的长度：%ld",array2.count);
		//将集合元素写入文件
		[array2 writeToFile:@"myArrayFile.txt" atomically:YES];
	}
}