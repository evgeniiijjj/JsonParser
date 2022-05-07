import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        for (Employee employee : jsonToList(readString("new_data.json"))) {
            System.out.println(employee);
        }
    }

    static String readString(String fileName) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            result.append(reader.readLine());
            while (reader.ready()) {
                result.append('\n');
                result.append(reader.readLine());
            }
        } catch (IOException e) { e.printStackTrace(); }
        return result.toString();
    }

    static List<Employee> jsonToList(String fileJson) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(fileJson, new TypeToken<List<Employee>>(){}.getType());
    }
}
