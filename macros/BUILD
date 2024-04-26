load("@rules_cc//cc:defs.bzl", "cc_binary")
load("//hello-world:generator.bzl", "hello_world")


hello_world(
    name = "code_dive",
)

hello_world(
    name = "everyone",
)


cc_binary(
    name = "hello_world_code_dive",
    srcs = [":code_dive"],
)


cc_binary(
    name = "hello_world_everyone",
    srcs = [":everyone"],
)
