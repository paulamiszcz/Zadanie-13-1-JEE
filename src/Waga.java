import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/kalkulatorwagi")
    public class Waga extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            loop(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            loop(request, response);
        }

        private void loop(HttpServletRequest request, HttpServletResponse response) throws IOException {
            WagaCalculator cw = new WagaCalculator();
            request.setCharacterEncoding("UTF-8");
            String kilogramy = request.getParameter("kilogramy");
            String gramy = request.getParameter("gramy");
            String miligramy = request.getParameter("miligramy");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            if(kilogramy != null && !kilogramy.isEmpty()) {
                Integer kg = Integer.valueOf(kilogramy);
                double gram = cw.kiloNaGram(kg);
                double mg = cw.kiloNaMg(kg);
                htmlWriter(writer, kg, gram, mg);
            } else if(gramy != null && !gramy.isEmpty()) {
                Integer gram = Integer.valueOf(gramy);
                double kg = cw.gramNaKilo(gram);
                double mg = cw.gramNaMg(gram);
                htmlWriter(writer, kg, gram, mg);
            } else if(miligramy != null && !miligramy.isEmpty()) {
                Integer mg = Integer.valueOf(miligramy);
                double gram = cw.mgNaGram(mg);
                double kg = cw.mgNaKilo(mg);
                htmlWriter(writer, kg, gram, mg);
            }
        }


        private void htmlWriter(PrintWriter writer, double kg, double gram, double mg) {
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h1>Podana wartość w przeliczeniu na:</h2>");
            writer.println("<p>Kilogramy: " + kg + "</p>");
            writer.println("<p>Gramy: " + gram + "</p>");
            writer.println("<p>Miligramy: " + mg + "</p>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

