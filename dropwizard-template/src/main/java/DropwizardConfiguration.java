import io.dropwizard.Configuration;

import javax.validation.Valid;

import lombok.Getter;

@Getter
public class DropwizardConfiguration extends Configuration {
  @Valid private String version;
}
