package org.scalatra
package helpers

import java.io.PrintWriter
import javax.servlet.{ServletContext, ServletConfig, FilterConfig}
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import java.lang.Throwable

trait Helpers extends ScalatraKernel {

  def header(h:String)(implicit request:HttpServletRequest) = Option( request.getHeader(h) )

  def yieldRequest(resource:String) { 
    servletContext.getRequestDispatcher(resource).forward(request, response) 
  }
  
  def yieldRequest {
    servletContext.getNamedDispatcher("default").forward(request, response) 
  }
}
