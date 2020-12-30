package test.apache.cxf.spring.hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;

public class TestBancoService {

	public static void main(String[] args) {

		String requestURL = "http://localhost:8080/Reporte_banco/services/bancoservice/getordenPago/USD";
		String httpMethod = HttpMethod.GET;
		String contentType = MediaType.APPLICATION_FORM_URLENCODED;
		String accept = MediaType.APPLICATION_JSON;
		String requestString = "{"

				+ "}";

		String[] requestParams = { requestURL, httpMethod, contentType, accept, requestString };

		String responseFromService = testBancoService(requestParams);
		System.out.println("Response String: " + responseFromService);
	}

	public static String testBancoService(String[] requestParams) {

		// local variables
		URL url = null;
		HttpURLConnection httpURLConnection = null;
		OutputStreamWriter outputStreamWriter = null;
		String responseMessageFromServer = null;
		String responseXML = null;

		try {
			url = new URL(requestParams[0]);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod(requestParams[1]);
			httpURLConnection.setRequestProperty("Content-Type", requestParams[2]);
			httpURLConnection.setRequestProperty("Accept", requestParams[3]);
			httpURLConnection.setDoOutput(true);

			System.out.println("Response code: " + httpURLConnection.getResponseCode());

			if (httpURLConnection.getResponseCode() == 200) {

				responseMessageFromServer = httpURLConnection.getResponseMessage();
				System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);
				responseXML = getResponseXML(httpURLConnection);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			httpURLConnection.disconnect();
		}
		return responseXML;
	}

	private static String getResponseXML(HttpURLConnection httpURLConnection) throws IOException {

		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		String readSingleLine = null;

		try {
			inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);

			while ((readSingleLine = bufferedReader.readLine()) != null) {
				stringBuffer.append(readSingleLine);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			bufferedReader.close();
			httpURLConnection.disconnect();
		}
		return stringBuffer.toString();
	}
}