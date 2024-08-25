public class JsonEmployeeStorage implements IEmployeeStorage {
    private final String filePath;
    private final Gson gson;

    public JsonEmployeeStorage(String filePath) {
        this.filePath = filePath;
        this.gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Date.class, new DateAdapter())
            .create();
    }

    @Override
    public List<Employee> load() {
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Employee>>(){}.getType();
            List<Employee> employees = gson.fromJson(reader, listType);
            return employees != null ? employees : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error al cargar los empleados: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void save(List<Employee> employees) {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(employees, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar los empleados: " + e.getMessage());
        }
    }
}