import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader downloader;

    public HttpImageStatusCli() {
        this.downloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code:");
        String input = scanner.nextLine();

        try {
            int code = Integer.parseInt(input);
            downloader.downloadStatusImage(code);
            System.out.println("Image downloaded successfully for HTTP status code: " + code);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        } catch (Exception e) {
            System.out.println("There is no image for HTTP status " + input);
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}

