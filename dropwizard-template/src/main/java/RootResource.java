import javax.ws.rs.GET;
import javax.ws.rs.Path;

import lombok.RequiredArgsConstructor;

@Path("/")
@RequiredArgsConstructor
public class RootResource {
  @GET
  public String root() {
    return "Hello World";
  }
}
