package org.example.calculatorjsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
        double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
        String operator = request.getParameter("operator");
        double result = 0;
        String message = "";

        try {
            switch (operator) {
                case "add":
                    result = firstOperand + secondOperand;
                    break;
                case "sub":
                    result = firstOperand - secondOperand;
                    break;
                case "mul":
                    result = firstOperand * secondOperand;
                    break;
                case "div":
                    if (secondOperand == 0) {
                        throw new ArithmeticException("Cannot divide by zero!");
                    }
                    result = firstOperand / secondOperand;
                    break;
                default:
                    message = "Invalid operator";
            }
            request.setAttribute("result", firstOperand + " " + getOperatorSymbol(operator) + " " + secondOperand + " = " + result);
        } catch (Exception e) {
            request.setAttribute("result", e.getMessage());
        }

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    private String getOperatorSymbol(String operator) {
        switch (operator) {
            case "add":
                return "+";
            case "sub":
                return "-";
            case "mul":
                return "*";
            case "div":
                return "/";
            default:
                return "?";
        }
    }
}
