load("@bazel_tools//tools/python:toolchain.bzl", "py_runtime_pair")

filegroup(
    name = "files",
    srcs = glob(["install/**"], exclude = ["**/* *"]),
    visibility = ["//visibility:public"],
)

filegroup(
    name = "interpreter",
    srcs = ["{interpreter_path}"],
    visibility = ["//visibility:public"],
)

# The py_runtime target denotes a platform runtime or a hermetic runtime.
# The platform runtime (system runtime) by its nature is non-hermetic.
# This py_runtime target is for our hermetic Python.
py_runtime(
    name = "py_runtime",
    files = [":files"],
    interpreter = ":interpreter",
    python_version = "PY3",
    visibility = ["//visibility:public"],
)

# A py_runtime_pair is used to couple hermetic Python2 and Python3 runtimes into a toolchain.
# We're not supporting py2, hence we pass None.
py_runtime_pair(
    name = "py_runtime_pair",
    py2_runtime = None,
    py3_runtime = ":py_runtime",
)

toolchain(
    name = "toolchain",
    exec_compatible_with = [
	{constraints},
    ],
    target_compatible_with = [
	{constraints},
    ],
    toolchain = ":py_runtime_pair",

    # We're just using the builtin Python toolchain type. 
    # A toolchain_type is simply a name that describes the type of the toolchain.
    toolchain_type = "@bazel_tools//tools/python:toolchain_type",
)