package com.huawei.fxboot.host_computer;

import com.huawei.fxboot.host_computer.config.SplashScreenCustom;
import com.huawei.fxboot.host_computer.view.HostComputerView;
import com.huawei.fxboot.host_computer.view.HostTestView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launchApp(MainApplication.class, HostTestView.class,new SplashScreenCustom(), args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);

    }
}
