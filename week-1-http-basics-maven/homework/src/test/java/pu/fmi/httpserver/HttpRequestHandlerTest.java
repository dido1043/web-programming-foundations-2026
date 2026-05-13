package pu.fmi.httpserver;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpRequestHandlerTest {

  private HttpRequestHandler handler;

  @BeforeEach
  void setUp() {
    handler = new HttpRequestHandler();
  }

  @Test
  void shouldSoftDeleteNotification() {

    HttpResponse<?> create =
            handler.handleRequest(HttpMethod.POST, "/notifications", "Title,Message,INFO");

    Notification created = (Notification) create.getResult();

    HttpResponse<?> delete =
            handler.handleRequest(HttpMethod.DELETE, "/notifications/" + created.getId(), null);

    assertEquals(HttpStatus.NO_CONTENT, delete.getHttpStatus());

    Notification result =
            (Notification)
                    handler
                            .handleRequest(HttpMethod.GET, "/notifications/" + created.getId(), null)
                            .getResult();

    assertTrue(result.isDeleted());
  }

  @Test
  void shouldReturnNotFoundWhenNotificationDoesNotExist() {

    HttpResponse<?> response = handler.handleRequest(HttpMethod.DELETE, "/notifications/999", null);

    assertEquals(HttpStatus.NOT_FOUND, response.getHttpStatus());
    assertEquals("Notification not found", response.getResult());
  }

  @Test
  void shouldReturnNotFoundWhenNotificationAlreadyDeleted() {

    HttpResponse<?> create =
            handler.handleRequest(HttpMethod.POST, "/notifications", "Title,Message,INFO");

    Notification created = (Notification) create.getResult();

    // първо изтриване
    handler.handleRequest(HttpMethod.DELETE, "/notifications/" + created.getId(), null);

    // второ изтриване
    HttpResponse<?> secondDelete =
            handler.handleRequest(HttpMethod.DELETE, "/notifications/" + created.getId(), null);

    assertEquals(HttpStatus.NOT_FOUND, secondDelete.getHttpStatus());
  }

}
