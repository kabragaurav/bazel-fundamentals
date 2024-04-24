### Notes can be found [here](https://quip.com/U7rcAwFLIRxH/Bazel-Fundamentals).

### Running

```
bazel run //:ProjectRunner
bazel run //:salutations
```

### Visualize dependencies
```
bazel query  --notool_deps --noimplicit_deps "deps(//:*)" --output graph
```

Sample here:
```
digraph mygraph {
  node [shape=box];
  "//:ProjectRunner_deploy.jar.unstripped\n//:ProjectRunner_deploy.jar"
  "//:ProjectRunner_deploy.jar.unstripped\n//:ProjectRunner_deploy.jar" -> "//:ProjectRunner_deployjars_internal_rule"
  "//:ProjectRunner_deploy-src.jar\n//:ProjectRunner-src.jar\n//:ProjectRunner.jar"
  "//:ProjectRunner_deploy-src.jar\n//:ProjectRunner-src.jar\n//:ProjectRunner.jar" -> "//:ProjectRunner"
  "//:salutations_deploy.jar\n//:salutations_deploy.jar.unstripped"
  "//:salutations_deploy.jar\n//:salutations_deploy.jar.unstripped" -> "//:salutations_deployjars_internal_rule"
  "//:libtextio.jar\n//:libtextio-src.jar"
  "//:libtextio.jar\n//:libtextio-src.jar" -> "//:textio"
  "//:salutations_deployjars_internal_rule"
  "//:salutations_deployjars_internal_rule" -> "//:salutations"
  "//:salutations_deploy-src.jar\n//:salutations-src.jar\n//:salutations.jar"
  "//:salutations_deploy-src.jar\n//:salutations-src.jar\n//:salutations.jar" -> "//:salutations"
  "//:salutations"
  "//:salutations" -> "//:textio"
  "//:salutations" -> "@bazel_tools//tools/jdk:launcher_flag_alias"
  "//:textio"
  "//:textio" -> "//:src/main/java/com/dependency/Salutations.java"
  "//:textio" -> "@maven//:org_beryx_text_io"
  "//:src/main/java/com/dependency/Salutations.java"
  "@maven//:org_beryx_text_io"
  "@maven//:org_beryx_text_io" -> "@maven//:v1/https/repo1.maven.org/maven2/org/beryx/text-io/3.4.1/text-io-3.4.1.jar\n@maven//:v1/https/repo1.maven.org/maven2/org/beryx/text-io/3.4.1/text-io-3.4.1-sources.jar"
  "@maven//:org_beryx_text_io" -> "@maven//:jline_jline"
  "@maven//:org_beryx_text_io" -> "@maven//:org_beryx_awt_color_factory"
  "@maven//:org_beryx_text_io" -> "@maven//:org_slf4j_slf4j_api"
  "@maven//:org_slf4j_slf4j_api"
  "@maven//:org_slf4j_slf4j_api" -> "@maven//:v1/https/repo1.maven.org/maven2/org/slf4j/slf4j-api/1.8.0-beta4/slf4j-api-1.8.0-beta4-sources.jar\n@maven//:v1/https/repo1.maven.org/maven2/org/slf4j/slf4j-api/1.8.0-beta4/slf4j-api-1.8.0-beta4.jar"
  "@maven//:jline_jline"
  "@maven//:jline_jline" -> "@maven//:v1/https/repo1.maven.org/maven2/jline/jline/2.14.6/jline-2.14.6.jar\n@maven//:v1/https/repo1.maven.org/maven2/jline/jline/2.14.6/jline-2.14.6-sources.jar"
  "@maven//:v1/https/repo1.maven.org/maven2/jline/jline/2.14.6/jline-2.14.6.jar\n@maven//:v1/https/repo1.maven.org/maven2/jline/jline/2.14.6/jline-2.14.6-sources.jar"
  "@maven//:v1/https/repo1.maven.org/maven2/org/beryx/text-io/3.4.1/text-io-3.4.1.jar\n@maven//:v1/https/repo1.maven.org/maven2/org/beryx/text-io/3.4.1/text-io-3.4.1-sources.jar"
  "@maven//:v1/https/repo1.maven.org/maven2/org/slf4j/slf4j-api/1.8.0-beta4/slf4j-api-1.8.0-beta4-sources.jar\n@maven//:v1/https/repo1.maven.org/maven2/org/slf4j/slf4j-api/1.8.0-beta4/slf4j-api-1.8.0-beta4.jar"
  "//:ProjectRunner_deployjars_internal_rule"
  "//:ProjectRunner_deployjars_internal_rule" -> "//:ProjectRunner"
  "//:ProjectRunner"
  "//:ProjectRunner" -> "//:src/main/java/com/greeting/ProjectRunner.java\n//:src/main/java/com/greeting/Greeting.java"
  "//:ProjectRunner" -> "@bazel_tools//tools/jdk:launcher_flag_alias"
  "@bazel_tools//tools/jdk:launcher_flag_alias"
  "//:src/main/java/com/greeting/ProjectRunner.java\n//:src/main/java/com/greeting/Greeting.java"
  "//:BUILD.bazel"
  "@maven//:org_beryx_awt_color_factory"
  "@maven//:org_beryx_awt_color_factory" -> "@maven//:v1/https/repo1.maven.org/maven2/org/beryx/awt-color-factory/1.0.1/awt-color-factory-1.0.1.jar\n@maven//:v1/https/repo1.maven.org/maven2/org/beryx/awt-color-factory/1.0.1/awt-color-factory-1.0.1-sources.jar"
  "@maven//:v1/https/repo1.maven.org/maven2/org/beryx/awt-color-factory/1.0.1/awt-color-factory-1.0.1.jar\n@maven//:v1/https/repo1.maven.org/maven2/org/beryx/awt-color-factory/1.0.1/awt-color-factory-1.0.1-sources.jar"
}
```

OR from <a href="https://dreampuf.github.io/GraphvizOnline">this</a>

![Dependency graph](./java-project/images/dependencies.svg)