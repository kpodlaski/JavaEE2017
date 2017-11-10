package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BirdsServlet
 */
@WebServlet("/bird")
public class BirdsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BirdsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getClass().getClassLoader().getResourceAsStream("images/bluebird.jpg");
		String bird = request.getParameter("bird");
		InputStream is;
		ClassLoader cl = this.getClass().getClassLoader();
		switch (bird){
			case "blue" : is = cl.getResourceAsStream("images/bluebird.jpg"); break;//f = new File("G:\\tmp\\bluebird.jpg"); break;
			case "yellow" : is =  cl.getResourceAsStream("images/yellowbird.jpg"); break;
			default : is = cl.getResourceAsStream("images/bluebird.jpg"); break;
		}
		
		response.setHeader("Content-Type", "image/jpeg");
		OutputStream os = response.getOutputStream();
		int b;
		while ( ( b=is.read() ) >=0 ){
			os.write(b);
		}
		is.close();
		os.close();
	}

	

}
