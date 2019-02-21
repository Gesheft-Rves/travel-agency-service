
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.lang.reflect.Field;

public class HTMLCreator {
    {
        String DIRECTORY_HTML_FRAGMENTS = "templates/doc/fragmentsHTML/";
        CONSTANT_CARD_FIELD         = getFile(DIRECTORY_HTML_FRAGMENTS + "frgCardField");
        CONSTANT_FORM_FIELD         = getFile(DIRECTORY_HTML_FRAGMENTS + "frgFormField");
        CONSTANT_LIST_FIELD_VALUE   = getFile(DIRECTORY_HTML_FRAGMENTS + "frgListFieldVal");
        CONSTANT_LIST_FIELD         = getFile(DIRECTORY_HTML_FRAGMENTS + "frgListField");
    }

    private File mainResourcesDirectory             = new File("src/main/resources");
    private  String DIRECTORY_PATH                  = (new StringBuilder(mainResourcesDirectory.getAbsolutePath()).append("\\templates\\doc\\webPages\\%pathClassName%Dir\\")).toString();
    private static String DIRECTORY_STATIC_HTML     = "templates/doc/staticHTML/%staticFragmentName%" ;
    private static String CONSTANT_LIST_FIELD ;
    private static String CONSTANT_LIST_FIELD_VALUE ;
    private static String CONSTANT_FORM_FIELD  ;
    private static String CONSTANT_CARD_FIELD ;


    private Writer writer = null;


    private String getFile(String fileName){
        String result = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void createFolders(Class clazz) {
        StringBuilder field = new StringBuilder();
        String filePath = field.append((DIRECTORY_PATH ).replace("%pathClassName%",clazz.getSimpleName().toLowerCase())).toString();
        folderIsExists(new File(filePath));
    }

    private void folderIsExists(File file) {
        if (!file.exists()) {
            System.out.println("creating directory: " + file.getName());
            boolean result = false;
            try{
                file.mkdir();
                result = true;
            }
            catch(SecurityException se){
                //handle it
            }
            if(result) {
                System.out.println("DIR created");
            }
        }
    }


    /**
     * Создает html страницу со списком сущностей
     * @param clazz класс сущности
     */
    void list(Class clazz) {
        createFolders(clazz);
        StringBuilder field = new StringBuilder(System.lineSeparator());
        StringBuilder fieldValues = new StringBuilder(System.lineSeparator());
        StringBuilder path = new StringBuilder();
        path.append(DIRECTORY_PATH.replace("%pathClassName%", clazz.getSimpleName().toLowerCase())).append(Thread.currentThread().getStackTrace()[1].getMethodName()).append( ".HTML");


        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(path.toString()), "utf-8"));

            Field[] fields = clazz.getDeclaredFields();

            for (Field f:fields) {
                f.setAccessible(true);
                field.append(CONSTANT_LIST_FIELD.replace("%fieldName%", f.getName())).append(System.lineSeparator());
                fieldValues.append(CONSTANT_LIST_FIELD_VALUE.replace("%fieldName%", f.getName())).append(System.lineSeparator());
            }

            String result  =  getFile(DIRECTORY_STATIC_HTML.replace("%staticFragmentName%","list.txt"));

            result = result.replace("%fields%", field.toString())
                    .replace       ("%fieldsValues%", fieldValues.toString())
                    .replaceAll    ("%className%", clazz.getSimpleName())
                    .replaceAll    ("%classNameToLowerCase%", clazz.getSimpleName().toLowerCase());

            writer.write(result);
        } catch (IOException  ex) {
            ex.printStackTrace();

        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }

    /**
     * Создает html страницу с формой сущности
     * @param clazz класс сущности
     */
    void form(Class clazz) {
        createFolders(clazz);
        StringBuilder field = new StringBuilder(System.lineSeparator());

        try {

            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(DIRECTORY_PATH.replace("%pathClassName%",clazz.getSimpleName().toLowerCase())+Thread.currentThread().getStackTrace()[1].getMethodName()+".HTML"), "utf-8"));

            Field[] fields = clazz.getDeclaredFields();

            for (Field f:fields) {
                f.setAccessible(true);
                field.append(CONSTANT_FORM_FIELD.replace("%fieldName%", f.getName())).append(System.lineSeparator());
            }

            String result  =  getFile(DIRECTORY_STATIC_HTML.replace("%staticFragmentName%","form.txt"));
            result = result.replace("%fields%", field.toString())
                    .replaceAll    ("%className%", clazz.getSimpleName())
                    .replaceAll    ("%classNameToLowerCase%", clazz.getSimpleName().toLowerCase());

            writer.write(result);

        } catch (IOException  ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }

    /**
     * Создает html страницу с формой сущности
     * @param clazz класс сущности
     */
    void card(Class clazz) {
        createFolders(clazz);
        StringBuilder field = new StringBuilder(System.lineSeparator());
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(DIRECTORY_PATH.replace("%pathClassName%",clazz.getSimpleName().toLowerCase())+Thread.currentThread().getStackTrace()[1].getMethodName()+".HTML"), "utf-8"));
            Field[] fields = clazz.getDeclaredFields();

            for (Field f:fields) {
                f.setAccessible(true);
                field.append(CONSTANT_CARD_FIELD.replace("%classNameToLowerCase%", clazz.getSimpleName().toLowerCase())
                        .replace("%className%", clazz.getSimpleName())
                        .replace("%fieldName%", f.getName())).append(System.lineSeparator());
            }

            String result  =  getFile(DIRECTORY_STATIC_HTML.replace("%staticFragmentName%","card.txt"));
            result = result.replace("%fields%", field.toString())
                    .replaceAll    ("%className%", clazz.getSimpleName())
                    .replaceAll    ("%classNameToLowerCase%", clazz.getSimpleName().toLowerCase());

            writer.write(result);
        } catch (IOException  ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }

    void createAll(Class clazz){
        list(clazz);
        card(clazz);
        form(clazz);
    }
}


