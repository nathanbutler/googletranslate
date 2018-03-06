import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import lombok.RequiredArgsConstructor;


@Path("/")
@RequiredArgsConstructor
public class RootResource {
  @GET
  public String root(@QueryParam("input") String input, @QueryParam("times") int times) {
      Translation tran = new Translation();

      //String output = "<html><h1>" + tran.translate(input) + "<h1></html>";
      /*String output = "<html><h1>" + tran.repeat(input, times) + "<h1>";
       output = output+ "<h2>" + tran.outJSON +"</h2></html>";*/
      String output = "<html><h1>" + tran.repeat2(input, times) + "<h1></html>";

    return output;
  }
}
