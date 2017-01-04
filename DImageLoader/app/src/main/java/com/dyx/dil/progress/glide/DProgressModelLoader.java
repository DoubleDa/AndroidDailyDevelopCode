package com.dyx.dil.progress.glide;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

import java.io.InputStream;

/**
 * project name：DImageLoader
 * class describe：
 * create person：dayongxin
 * create time：2016/12/30 下午5:20
 * alter person：dayongxin
 * alter time：2016/12/30 下午5:20
 * alter remark：
 */
public class DProgressModelLoader implements StreamModelLoader<String> {
    private DProgressUIListener listener;
    private ModelCache<String, String> modelCache;

    public DProgressModelLoader(DProgressUIListener listener) {
        this(listener, null);
    }

    public DProgressModelLoader(ModelCache<String, String> modelCache) {
        this(null, modelCache);
    }

    public DProgressModelLoader(DProgressUIListener listener, ModelCache<String, String> modelCache) {
        this.listener = listener;
        this.modelCache = modelCache;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(String model, int width, int height) {
        String result = null;
        if (modelCache != null) {
            result = modelCache.get(model, width, height);
        }
        if (result == null) {
            result = model;
            if (modelCache != null) {
                modelCache.put(model, width, height, result);
            }
        }
        return new DProgressDataFetcher(result, listener);
    }
}
