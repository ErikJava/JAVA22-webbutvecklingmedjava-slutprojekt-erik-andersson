package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GettheWeather;
import model.WeatherBean;

@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
        // Gets the city & country
		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");
		
		// Cookie that saves previous searches
		Cookie[] cookies = request.getCookies();
        String temp = "";
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("city")) {
                temp = cookies[i].getValue();
            }

        }
        temp = temp + "-" + cityStr;
        
        // Sets the time limit for the Cookie
        Cookie ck = new Cookie("city", temp);
        ck.setMaxAge(100);
        response.addCookie(ck);
			
        // JavaBean for the weather
		WeatherBean wBean = new WeatherBean(cityStr, countryStr);

		GettheWeather.getWeather(wBean);

		request.setAttribute("wBean", wBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/showWeather.jsp");
		rd.forward(request, response);
	}

}