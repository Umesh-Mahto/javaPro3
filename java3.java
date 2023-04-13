import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication{

	public static void main(String[] args) throws Exception{

		String url = "https://api.nationalize.io/?name=nathaniel";

		// Building a request
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

		//getting the http client
		HttpClient httpClient = HttpClient.newBuilder().build();

		HttpResponse httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// status code and body
		System.out.println(httpResponse.statusCode());
		System.out.println(httpResponse.body());
	}

}