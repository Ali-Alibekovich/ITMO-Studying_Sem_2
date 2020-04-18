package Commands.Utils;

import Collection.CollectionManager;
import StoredClasses.Organization;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Парсер JSON: отвечает за сохранение в файл и загрузку из него.
 */
public class ParserJson {
    private static String fileName;

    public static void setFileName(String fileName) {
        ParserJson.fileName = fileName;
    }

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder
            .registerTypeAdapter(LocalDateTime.class, new TypeAdapter<LocalDateTime>() {
                @Override
                public void write(JsonWriter out, LocalDateTime value) throws IOException {
                    out.value(value.toString());
                }

                @Override
                public LocalDateTime read(JsonReader in) throws IOException {
                    return LocalDateTime.parse(in.nextString());
                }
            })
            .serializeNulls()
            .setPrettyPrinting()
            .enableComplexMapKeySerialization()
            .create();

    public static void collectionToJson() {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName))) {
            gson.toJson(CollectionManager.getCollection(), writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fromJsonToCollection() {
        if (fileName != null) {
            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName))) {
                CollectionManager.initializeCollection();
                List<Organization> organizations = gson.fromJson(reader, new TypeToken<List<Organization>>() {
                }.getType());
                if (organizations.size() > 0) for (Organization organization : organizations) {
                    CollectionManager.addJson(organization);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (SecurityException e) {
                System.out.println("Недостаточно прав для открытия файла.");
            } catch (NullPointerException e) {
                System.out.println("В файле нет объектов");
            } catch (com.google.gson.JsonSyntaxException e) {
                System.out.println("Ошибка в содержании файла " + e.getMessage());
            }
        }
    }
}