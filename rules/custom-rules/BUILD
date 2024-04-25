load("//:foo.bzl", "foo_binary")
load("//:foo1.bzl", "foo_binary1")
load("//:hello-world.bzl", "hello_world")

print("BUILD file of Gaurav")

foo_binary(name = "bin1")
foo_binary(name = "bin2")   
foo_binary1(
    name = "bin",
    username = "Gaurav",
)
hello_world(
    name = "hello-gaurav",
    username = "Gaurav",
    template = "file.cc.tpl",
)
cc_binary(
    name = "say_hello_to_gaurav",
    srcs = [":hello-gaurav"],
)
