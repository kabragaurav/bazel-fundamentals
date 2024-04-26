def hello_world(name, visibility = None):
    native.genrule(
        name = name,
        srcs = [name + ".txt"],
        outs = [name + ".cpp"],
        cmd = "$(location //hello-world:generator) $< $@",
        tools = ["//hello-world:generator"],
        visibility = visibility,
    ) 

