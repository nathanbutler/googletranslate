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

      System.out.println(times);

      String output = "<html><h1>" + tran.translate(input) + "<h1></html>";
      //String output = tran.translate(input);

    return output;
  }
}
