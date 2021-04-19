package com.wjruiying.galleryviewer;

import java.util.List;

/**
 * @author changshuaiji
 * @description <p> main view </P>
 * @date 2021/4/14
 */
public interface MainView {
    void getPos(int position);
    void getFirstData(List<String> dataSource);
}
