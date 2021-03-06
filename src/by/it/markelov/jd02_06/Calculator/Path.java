package by.it.markelov.jd02_06.Calculator;

import java.io.File;

public class Path {
    public static File pathOfThisDirectory(Class<?> cl) {
        Package aPackage = cl.getPackage();//пакет
        String namePackage = aPackage.getName();//имя пакета
        String pathPackage = namePackage.replaceAll("\\.", "\\\\");//замена точек на \
        String property = System.getProperty("user.dir");//путь к папке проекта
        File file = new File(property + File.separator + "src" + File.separator + pathPackage + File.separator);//объект класса File (путь к рабочей папке)
        return file;
    }
}
