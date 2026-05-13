package pu.fmi.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomHttpServer {

  public static void main(String[] args) throws IOException {
    System.out.println("Здравейте, това е моят custom http сървър");

    int port = 8082;

    // TCP Listener - Слуша за TCP заявки на даден порт
    ServerSocket serverSocket = new ServerSocket(port);

    while (true) {
      // Q: Какво прави метода accept() ?
      // A: Чака даден уеб клиент да установи TCP връзка.
      // Още може да се каже, че блокира изпълнението (т.е. програмата „замръзва“) докато не се свърже нов клиент

      // Когато клиент се свърже, accept():
      // 1. Създава нов обект от тип Socket, който представлява връзката с този клиент
      // 2. Връща текущата установена TCP заявка
      Socket currentSocket = serverSocket.accept();

      System.out.println("IP адрес на сървъра: " + currentSocket.getInetAddress());
      System.out.println("Порта на сървъра:" + currentSocket.getPort());
      System.out.println("Локален порт:" + currentSocket.getLocalPort());

      // Искам да ми дадеш stream от HTTP заявката.
      // Тук getInputStream() e поток от байтове, който идва от клиента към сървър.
      // Работи точно като четене от файл — но вместо това чете от уеб мрежата
      InputStream request = currentSocket.getInputStream();

      byte[] requestBytes = new byte[1024];  // Заделяне на масив от байтове, в който ще се съхраняват данните от клиента
      int bytesRead = request.read(requestBytes); // Чете до 1024 байта от входния поток (от клиента) и ги записва в буфера.

      String requestAsText = new String(requestBytes, 0, bytesRead); // Преобразуване прочетените байтове в низ
      System.out.println("Заявка: " + requestAsText);

      // Това дава поток от байтове, който отива от сървъра към клиента.
      // Използва се за изпращане на отговор — напр. HTML, JSON, текст, HTTP headers и т.н.
      // Или „писане към уеб мрежата“
      OutputStream response = currentSocket.getOutputStream();

      // Body-то на нашият HTTP Response
      String body = "<h1>Здравейте, аз съм Цецо</h1>";

      // Направи HTTP response
      String responseAsString =
          "HTTP/1.1 200 OK\r\n" +
              "Content-Type: text/html;charset=UTF-8\r\n" + // искам връщаното body да се интерпретира от браузъра като html елемент
              "Content-Length: " +  body.getBytes(StandardCharsets.UTF_8).length + "\r\n" + // оказвам колко голямо ще е съдържанието на body-то
              "Connection: close\r\n" + "\r\n" +
              body;

      //  * "\r\n" представлява специална последователност от два символа,
      //  която обозначава край на ред в някои операционни системи, най-вече в Windows.
      //   - \r	Carriage Return (CR) - Връща курсора в началото на реда
      //   - \n	Line Feed (LF) - Премества курсора на следващия ред

      // Запиши го и го върни на браузъра
      response.write(responseAsString.getBytes());
      response.flush();

      // Затвори TCP връзката
      currentSocket.close();
    }
  }
}