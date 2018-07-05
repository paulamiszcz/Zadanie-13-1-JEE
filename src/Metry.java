import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/kalkulaormetrow")
    public class Metry extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            loop(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            loop(request, response);
        }

        private void loop(HttpServletRequest request, HttpServletResponse response) throws IOException {
            MetryCalculator cm = new MetryCalculator();
            request.setCharacterEncoding("UTF-8");
            String metry = request.getParameter("metry");
            String centy = request.getParameter("centymetry");
            String mili = request.getParameter("milimetry");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            if(metry != null && !metry.isEmpty()) {
                Double metryInt = Double.valueOf(metry);
                double centymetry = cm.metryNaCenty(metryInt);
                double milimetry = cm.metryNaMili(metryInt);
                htmlWriter(writer, metryInt, centymetry, milimetry);
            } else if(centy != null && !centy.isEmpty()) {
                Double centyInt = Double.valueOf(centy);
                double metryC = cm.centyNaMetry(centyInt);
                double milimetry = cm.centyNaMili(centyInt);
                htmlWriter(writer, metryC, centyInt, milimetry);
            } else if(mili != null && !mili.isEmpty()) {
                Double miliInt = Double.valueOf(mili);
                double metryM = cm.miliNaMetry(miliInt);
                double centymetry = cm.miliNaCenty(miliInt);
                htmlWriter(writer, metryM, centymetry, miliInt);
            }
        }

        private void htmlWriter(PrintWriter writer, double metryM, double centymetry, double miliInt) {
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h1>Podana wartość w przeliczeniu na:</h2>");
            writer.println("<p>Metry: " + metryM + "</p>");
            writer.println("<p>Centymetry: " + centymetry + "</p>");
            writer.println("<p>Milimetry: " + miliInt + "</p>");
            writer.println("</body>");
            writer.println("</html>");
        }

    }

