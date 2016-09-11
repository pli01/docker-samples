all:
	echo
build-scratch:
	( cd base-image && sudo -E bash -x build-debian.sh )

build-debian-latest:
	make -C debian build
build-ansible:
	make -C debian-ansible build
build-ansible2:
	make -C debian-ansible2 build

build-nginx:
	make -C debian-nginx build

build-java:
	make -C java build

build-rsyslog:
	make -C rsyslog build

build-elk-input:
	make -C elk-input build

build-image: build-debian-latest build-ansible2 build-nginx
# build-rsyslog build-elk-input

build-all: build-scratch build-image
	echo
