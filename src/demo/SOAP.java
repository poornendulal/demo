package demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SOAP {

	public static void main(String[] args) {
		try {
			String uri = "http://www.dneonline.com/calculator.asmx?op=Add";

			String postData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
					+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
					+ "  <soap:Body>\r\n" + "    <Add xmlns=\"http://tempuri.org/\">\r\n" + "      <intA>1</intA>\r\n"
					+ "      <intB>2</intB>\r\n" + "    </Add>\r\n" + "  </soap:Body>\r\n" + "</soap:Envelope>";
			URL url = new URL(uri);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true); // This is important. If you not set doOutput it is default value is false and
											// throws java.net.ProtocolException: cannot write to a URLConnection
											// exception
			connection.setRequestMethod("POST"); // This is method type. If you are using GET method you can pass by
													// url. If method post you must write
			connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8"); // it is important if you post
																						// utf-8 characters

			DataOutputStream wr = new DataOutputStream(connection.getOutputStream()); // This three lines is importy for
																						// POST method. I wrote
																						// preceding comment.
			wr.write(postData.getBytes());
			wr.close();

			InputStream xml = connection.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(xml));
			String line = "";
			StringBuilder xmlResponse = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				xmlResponse = xmlResponse.append(line);
			}
			String xmlfile = "c:\\\\test.xml";
			File file = new File(xmlfile); // If you want to write as file to local.
			callxmlwrite(xmlResponse, file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void callxmlwrite(StringBuilder xmlResponse, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		try {
			fileWriter.write(xmlResponse.toString());

		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			fileWriter.close();
		}
	}

}
