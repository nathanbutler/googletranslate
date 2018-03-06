# Google Translate repeater

Using Drop Wizard Google Tranlsate API I am able to take a phrase and run it through the translator many times

## Getting Started

### Prerequisites

Requires Java 8 and Gradle 4.4 to be installed.

### Build Instructions
```
git clone https://github.com/nathanbutler/googletranslate.git
cd googletranslate
./gradlew :dropwizard-template:clean :dropwizard-template:shadowJar
java -jar dropwizard-template/root.jar server dropwizard-template/local.yaml
```

## Built With

* [Dropwizard](http://www.dropwizard.io/1.1.4/docs/) - The web framework used
* [Guava](https://github.com/google/guava/wiki/Release23) - Utility functions
* [Lombok](https://projectlombok.org/) - Annotations for less boilerplate code

## Contributing

Fork the project and submit a PR and one of the maintainers will be in touch.

## Authors

* Nathan Butler - Developer / maintainer - [nathanbutler](https://github.com/nathanbutler)

See also the list of [contributors](https://github.com/abatilo/dropwizard-template/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
