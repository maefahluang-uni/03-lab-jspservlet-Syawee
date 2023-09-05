package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        Double weight = Double.parseDouble(request.getParameter("weight"));
        Double height = Double.parseDouble(request.getParameter("height"));
        //TODO: calculate bmi
        long BMI = Math.round(weight / (height * height));
        //TODO: determine the built from BMI
        String built;
      
        if (BMI < 18.5){
            built =  "underweight";
        }else if (BMI>=18.5 && BMI <25) {
            built =  "normal";
        }else if (BMI>=25 && BMI < 30 ) {
            built =  "overweight";
        }else if (BMI>=30 && BMI < 35 ) {
            built =  "obese";
        }else  {
            built =  "extremely obese";
        }
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi",BMI);
        request.setAttribute("built", built);
        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);
    }
    
}
