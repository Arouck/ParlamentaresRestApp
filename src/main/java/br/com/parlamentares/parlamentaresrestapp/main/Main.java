package br.com.parlamentares.parlamentaresrestapp.main;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";

        Tomcat tomcat = new Tomcat();
        String webPort = "9090";

        tomcat.setPort(Integer.parseInt(webPort));

        StandardContext standardContext = (StandardContext) tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot webResourceRoot = new StandardRoot(standardContext);

        webResourceRoot.addPreResources(new DirResourceSet(webResourceRoot, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));

        standardContext.setResources(webResourceRoot);

        tomcat.start();
        tomcat.getServer().await();
    }
}
