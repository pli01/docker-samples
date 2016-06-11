all:
	echo
build-scratch:
	cd base-image && bash build.sh

debian-latest:
	make -C debian build
ansible:
	make -C debian-ansible build
nginx:
	make -C debian-nginx build

build-image: debian-latest ansible nginx

build-all: build-scratch build-image
	echo
