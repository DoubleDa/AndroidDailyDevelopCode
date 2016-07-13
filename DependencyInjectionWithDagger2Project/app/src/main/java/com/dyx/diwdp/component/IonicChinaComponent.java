package com.dyx.diwdp.component;

import com.dyx.diwdp.MainActivity;
import com.dyx.diwdp.module.IonicChinaModule;
import com.dyx.diwdp.module.NetModule;
import com.dyx.diwdp.scope.ArticleScope;

import dagger.Component;

/**
 * project name：DependencyInjectionWithDagger2Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/13 下午5:27
 * alter person：dayongxin
 * alter time：16/7/13 下午5:27
 * alter remark：
 */
@ArticleScope
@Component(dependencies = NetModule.class, modules = IonicChinaModule.class)
public interface IonicChinaComponent {
    void inject(MainActivity activity);
}
