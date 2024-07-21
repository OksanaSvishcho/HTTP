import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpStatusChecker {
    private static final String BASE_URL = "https://http.cat/";

    private OkHttpClient client;

    public HttpStatusChecker() {
        this.client = new OkHttpClient();
    }

    public String getStatusImage(int code) throws Exception {
        String url = BASE_URL + code + ".jpg";
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() == 404) {
                throw new Exception("Image not found for HTTP status code: " + code);
            }
            return url;
        }
    }

    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();
        try {
            System.out.println(checker.getStatusImage(200));
            System.out.println(checker.getStatusImage(10000));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
