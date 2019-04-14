package configuration;

public class Constants {
    public static final int PORT = 9876;
    public static final String DB_PATH = "jdbc:sqlite: flowers.db";

    public static final int OK_200 = 200;
    public static final int CREATED_201 = 201;
    public static final int NOT_FOUND_404 = 404;
    public static final int INTERNAL_SERVER_ERROR_500 = 500;
    public static final int BAD_REQUEST_400 = 400;

    private Constants() {}
}
