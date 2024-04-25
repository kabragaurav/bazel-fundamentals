def _foo_binary1_impl(ctx):
    out = ctx.actions.declare_file(ctx.label.name)
    ctx.actions.write(
        output = out,
        content = "Hello {}!\n".format(ctx.attr.username),
    )
    return [DefaultInfo(files = depset([out]))]

foo_binary1 = rule(
    implementation = _foo_binary1_impl,
    attrs = {
        "username": attr.string(),
    },
)