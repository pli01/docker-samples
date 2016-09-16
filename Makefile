DISTRIB ?=
VERSION ?=
ifdef VERSION
name    = $(DISTRIB)/$(VERSION)
endif

tag     ?= latest

include $(DISTRIB)/Makefile.inc

build_args += $(shell [ -z "${http_proxy}" ] || echo " --build-arg http_proxy=${http_proxy} ")
build_args += $(shell [ -z "${https_proxy}" ] || echo " --build-arg https_proxy=${http_proxy} ")

all:
	echo make DISTRIB= VERSION=

build: $(DISTRIB)/Dockerfile
	( cd $(DISTRIB) && docker build $(build_args) --force-rm -t $(name):$(tag) -f Dockerfile . )

build-scratch:
	make -C base-image DISTRIB=$(DISTRIB) VERSION=$(VERSION)

#build-$(DISTRIB)-ansible:
#	make -C $(DISTRIB)-ansible build
#build-$(DISTRIB)-ansible2:
#	make -C $(DISTRIB)-ansible2 build
#build-$(DISTRIB)-nginx:
#	make -C $(DISTRIB)-nginx build
#build-java:
#	make -C java build
#build-rsyslog:
#	make -C rsyslog build
#build-elk-input:
#	make -C elk-input build
#build-jenkins2:
#	make -C debian-jenkins2 build
#
build-image: build-$(DISTRIB)-latest build-$(DISTRIB)-ansible2 build-nginx
# build-rsyslog build-elk-input

build-all: build-scratch build-image
	echo
