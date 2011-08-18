package org.scalatra
package helpers

import javax.servlet.http.{HttpServletRequest}

trait Helpers extends ScalatraKernel {

  // Get an incoming HTTP header as an Option (if that header is present)
  def header(h:String)(implicit request:HttpServletRequest):Option[String] = 
    Option( request.getHeader(h) )

  // Serve that path with whatever's registered to handle that.
  // An "internal forward". Useful for serving static files in response to some conditions.
  def yieldRequest(resource:String) { 
    servletContext.getRequestDispatcher(resource).forward(request, response) 
  }
  
  // Respond to the current request with the servlet "default".
  // Useful for deffering to static files.
  def yieldRequest {
    servletContext.getNamedDispatcher("default").forward(request, response) 
  }
}
