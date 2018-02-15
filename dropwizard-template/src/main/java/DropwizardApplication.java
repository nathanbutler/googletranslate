import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import lombok.SneakyThrows;

public class DropwizardApplication
  extends Application<DropwizardConfiguration> {

  @Override
  public void run(DropwizardConfiguration config, Environment env)
    throws Exception {
    BaseResourceFactory.ResourceFactory resources =
      new BaseResourceFactory.ResourceFactory(config, env);
    env.jersey().register(resources.getRootResource());
  }

  @SneakyThrows
  public static void main(String[] args) {
    new DropwizardApplication().run(args);
  }
}
