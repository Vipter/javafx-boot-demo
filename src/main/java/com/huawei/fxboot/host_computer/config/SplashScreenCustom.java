package com.huawei.fxboot.host_computer.config;

import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.Parent;

public class SplashScreenCustom extends SplashScreen {

    @Override
    public Parent getParent() { // 在这里可以设置闪屏窗口大小，默认图片大小
        return super.getParent();
    }

    @Override
    public boolean visible() { // 是否显示闪屏，默认显示
        return super.visible();
    }

    @Override
    public String getImagePath() {
        return "/images/number.gif";
    }
}
