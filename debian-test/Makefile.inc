name ?= test
build_args += $(shell [ -z "${myvar}" ] || echo " --build-arg myvar=${myvar} ")

