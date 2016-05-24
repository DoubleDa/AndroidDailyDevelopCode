#import <Foundation/Foundation.h>

/*
* setter方法的复制选项
*/
@interface FKItem:NSObject
@property (nonatomic,copy) NSMutableString * name;
@end

- (void) setName:(NSMutableString *) name
{
	_name=name;
}

- (NSMutableString *) name
{
	return _name;
}