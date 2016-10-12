name ?= elk
dest = "ansible-elk"
#url = "https://github.com/pli01/ansible-elk/archive/master.zip"
url = "https://github.com/pli01/ansible-elk.git"
build_args += $(shell [ -z "${dest}" ] || echo " --build-arg dest='${dest}' ")
build_args += $(shell [ -z "${url}" ] || echo " --build-arg url='${url}' ")
