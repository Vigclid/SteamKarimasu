package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import model.student;

public final class addStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/includes/header.jsp");
    _jspx_dependants.add("/includes/column_left_home.jsp");
    _jspx_dependants.add("/includes/column_right_news.jsp");
    _jspx_dependants.add("/includes/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Trường ĐẠI HỌC Apple </title>\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/favicon.ico\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles/main.css\">\n");
      out.write("   <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js\"></script>\n");
      out.write("</head>\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <header>\n");
      out.write("         <meta charset=\"UTF-8\">\n");
      out.write("        <img src=\"images/logo_apple.jpg\" \n");
      out.write("             alt=\"Trường Đại học Apple\" width=\"243\" height=\"85\" >\n");
      out.write("        <h1>Apple University</h1>\n");
      out.write("        <h2>Trường Đại học Apple - Cơ sở Đà Nẵng</h2>\n");
      out.write("    </header>\n");
      out.write("    <nav id=\"nav_bar\">\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"search.jsp\">\n");
      out.write("                    Searching</a></li>\n");
      out.write("                    <li><a href=\"staff.jsp\">\n");
      out.write("                    Staff</a></li>\n");
      out.write("            <li><a href=\"\">\n");
      out.write("                    News</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </nav>");
      out.write('\r');
      out.write('\n');
      out.write("<aside id=\"sidebarA\">\n");
      out.write("    <nav>\n");
      out.write("      <ul>\n");
      out.write("          <li><a class=\"current\" href=\"index.jsp\">Home</a></li>\n");
      out.write("          <li><a href=\"addStudent.jsp\"> Student Enrollment</a></li>\n");
      out.write("          <li>\n");
      out.write("              <a href=\"#\" onclick=\"submitForm()\">Student list</a>\n");
      out.write("              <form id=\"studentListForm\" action=\"StudentServlet\" method=\"POST\" style=\"display: none;\">\n");
      out.write("              </form>\n");
      out.write("          </li>\n");
      out.write("          <li><a href=\"search.jsp\">Student Search</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function submitForm() {\n");
      out.write("            document.getElementById(\"studentListForm\").submit();\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</aside>");
      out.write("\r\n");
      out.write("<section id=\"main-contain\" class=\"column\">\r\n");
      out.write("    <h1>\r\n");
      out.write("        Add student\r\n");
      out.write("    </h1>\r\n");
      out.write("    <form action = \"StudentServlet\" method=\"POST\">\r\n");
      out.write("         <table border=\"0\">\r\n");
      out.write("            <tr >\r\n");
      out.write("                <td>StudentID: </td>\r\n");
      out.write("                <td> <input type=\"text\" name=\"ID\"></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("             <tr>\r\n");
      out.write("                 <td>Name: </td>\r\n");
      out.write("                 <td> <input type=\"text\" name=\"name\"></td>\r\n");
      out.write("             </tr>\r\n");
      out.write("             <tr>\r\n");
      out.write("                 <td>Gender: </td>\r\n");
      out.write("                 <td> <input type=\"radio\" name=\"gender\" value=\"male\"> Male </td>\r\n");
      out.write("                 <td> <input type=\"radio\" name=\"gender\" value=\"female\"> Female </td>\r\n");
      out.write("             </tr>\r\n");
      out.write("             <tr>\r\n");
      out.write("                 <td>DOB: </td>\r\n");
      out.write("                 <td> <input type=\"date\" name=\"DOB\"></td>\r\n");
      out.write("             </tr>\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td> <input type=\"submit\" value=\"Submit\"> </td>\r\n");
      out.write("             </tr>\r\n");
      out.write("         </table>\r\n");
      out.write("    </form>\r\n");
      out.write("</section>\r\n");
      out.write("\n");
      out.write("<aside id=\"sidebarB\">\n");
      out.write("    <h1>New Release</h1>\n");
      out.write("    <img src=\"images/logo_apple.jpg\" width=\"100\" \n");
      out.write("         alt=\"Activities Board\">\n");
      out.write("    <h2><a href=\"catalog/product/8601\" class=\"no_underline\">\n");
      out.write("        Apple University News\n");
      out.write("    </a></h2>\n");
      out.write("    <p class=\"news_item\">Summer semester started on 13/05/2022.</p>\n");
      out.write("</aside>");
      out.write('\r');
      out.write('\n');
      out.write("    <footer>\n");
      out.write("        <p>Hit Counter ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Counter.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" &copy; Copyright ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentYear}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" Apple University. \n");
      out.write("            All rights reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
