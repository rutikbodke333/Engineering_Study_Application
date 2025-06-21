package com.engineeringstudy.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

// AccessDeniedHandler is an interface provided by Spring Security.
//It defines what to do when a user is authenticated (logged in) but tries to access a resource they are not allowed to (due to missing roles/permissions).

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

//	Below Method executed when an authenticated user tries to access a protected resource 
//	they are not authorized for (i.e., wrong role).

//	This method is called by Spring Security when it catches an AccessDeniedException.
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException {

		response.setStatus(HttpServletResponse.SC_FORBIDDEN); // set HTTP status code to 403 Forbidden
		response.setContentType("application/json"); // set the content type of the response to JSON
		response.getWriter()
				.write("{\"error\": \"Access Denied: You don't have permission to access this resource.\"}");
//        "error": "Access Denied: You don't have permission to access this resource."

//        | Code                   | Meaning                                                                                                                      |
//        | ---------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
//        | `response.getWriter()` | Gets a `PrintWriter` object to write text data (like a string) to the response.                                              |
//        | `.write(...)`          | Writes the actual text (in this case, a JSON string) to the HTTP response body.                                              |
//        | `"{\"error\": ... }"`  | This is a **JSON string**, escaped in Java syntax. The backslashes (`\`) are used to escape double quotes inside the string. |

	}
}
