genrule(
    name = "concat",
    srcs = ["f2.txt", "f1.txt", "f3.txt"],
    outs= ["concat.txt"],
    #cmd = "cat $(location //:f1.txt) $(location //:f2.txt) > $@",
    cmd= "cat $(SRCS) > $@",
)

genrule(
    name = "process_data",
    srcs = ["process_data.py", "f1.txt", "f2.txt"],
    outs = ["output.txt"],
    cmd = "python3 process_data.py f1.txt f2.txt $@",
)

genrule(
    name = "copy_files",
    srcs = ["f1.txt"],
    outs = ["copy_file.txt"],
    cmd = "cp $< $@",
)

filegroup(
    name = "files",
    srcs = ["f1.txt", "f2.txt", "f3.txt"],
)

genrule(
    name = "cat_files",
    srcs = [":files", ":copy_files"],
    outs = ["cat_files.txt"],
    cmd =  "cat $(locations :files) $(location :copy_files)> $@",
)
