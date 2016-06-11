all:
	echo
build-scratch:
	cd base-image && bash build.sh

build-debian-latest:
	make -C debian build
build-ansible:
	make -C debian-ansible build
build-nginx:
	make -C debian-nginx build

build-rsyslog:
	make -C rsyslog build

build-elk-input:
	make -C elk-input build

build-image: build-debian-latest build-ansible build-nginx build-rsyslog build-elk-input

build-all: build-scratch build-image
	echo
