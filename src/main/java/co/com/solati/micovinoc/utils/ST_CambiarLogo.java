package co.com.solati.micovinoc.utils;
import org.apache.commons.io.FileUtils;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ST_CambiarLogo {
    public void changeLogo() {
        String strFileOrigen = "src/test/resources/images/serenity-logo.png";
        String strPathDestino = "target/site/serenity/images";

        Path ptPathOrigen = Paths.get(strFileOrigen);

        if (Files.exists(ptPathOrigen)) {

            Path ptPathDestino = Paths.get(strPathDestino);
            if (Files.exists(ptPathDestino)) {

                File flFileDestino = new File(strPathDestino + "/serenity-logo.png");
                File flFileOrigen = new File(strFileOrigen);

                long lngPesoOrigen = flFileOrigen.length();
                long lngPesoDestino = flFileDestino.length();

                String s;
                Process p;
                try {
                    Thread.sleep(1000);
                    p = Runtime.getRuntime().exec("gradle aggregate");
                    p.waitFor();
                    p.destroy();
                } catch (Exception e) {}
                if (lngPesoOrigen!=lngPesoDestino){
                    File flPathDestino = new File(strPathDestino);
                    try
                    {
                        FileUtils.copyFileToDirectory(flFileOrigen, flPathDestino);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();

                    }
                }
                try{
                    Date date = new Date();
                    DateFormat hourdateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                    /*p = Runtime.getRuntime().exec("mv target/site/serenity target/site/serenity"+hourdateFormat.format(date));
                    p.waitFor();
                    p.destroy();*/
                } catch (Exception e) {}
            }
        }

    }

}
