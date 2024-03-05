package cn.donting.web.os.desktop;

import java.io.File;
import java.net.MalformedURLException;

public class Test {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println(new File("./").toURL());
    }
}
