package anotherquestion;

import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by icondor on 04/02/17.
 */

@WebServlet("/aq")
public class AnotherQuestionServlet extends HttpServlet {

  public void service(HttpServletRequest request, HttpServletResponse response) {

      List listaCititaDinDB;


        String action = request.getParameter("action");
        if(action!=null && action.equals("list"))
        {
            System.out.println("voi afisa lista ");

            //fac jsonul
            JSONObject json = new JSONObject();

          //  json.put("questions",SingleList.getInstance().getIntrebari());


            CsongorDB csdb = new CsongorDB();
            listaCititaDinDB =  csdb.getFaqList(); // returneaza o lista cu tot ce e in db

            json.put("questions",listaCititaDinDB);

            String result = json.toString();
            System.out.println("result:"+result);
            returnJsonResponse(response, result);


          //  String result=json.toString();

            System.out.println("result:"+result);
            returnJsonResponse(response, result);

            /*

        {"tasks":[{"name":"prima intrebare"},{"name":"a doua intrebare"}]}

             */
        }

        else {


            System.out.println("voi adauga in lista");
            String question = request.getParameter("value");
            String answer = request.getParameter("value");


        //    SingleList.getInstance().addIntrebare(intrebarea);


         //   SingleList.getInstance().afiseza();


            CsongorDB csdb = new CsongorDB();
            csdb.insert(question,answer);


            System.out.println("------------");
        }


    }


    private void returnJsonResponse(HttpServletResponse response, String jsonResponse) {
        response.setContentType("application/json");
        PrintWriter pr = null;
        try {
            pr = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert pr != null;
        pr.write(jsonResponse);
        pr.close();
    }
}
