DISTRIB ?=
VERSION ?=

# include vars per distrib
-include $(DISTRIB)/Makefile.inc

tag     ?= latest
ifdef VERSION
newname  :=  $(name)/$(VERSION)
#tag      := $(VERSION)
endif

build_args += $(shell [ -z "${http_proxy}" ] || echo " --build-arg http_proxy=${http_proxy} ")
build_args += $(shell [ -z "${https_proxy}" ] || echo " --build-arg https_proxy=${http_proxy} ")

SUBDIRS = $(DISTRIB) $(DISTRIB)-ansible2 $(DISTRIB)-nginx java $(DISTRIB)-jenkins2
# build-rsyslog build-elk-input

all:
	echo make build DISTRIB= [VERSION=]

.PHONY: subdirs $(SUBDIRS)

subdirs: $(SUBDIRS)

$(SUBDIRS):
	@$(MAKE) build DISTRIB=$@ VERSION=$(VERSION)

build-image: subdirs
	@echo "# $@"

build: $(DISTRIB)/Dockerfile
	( cd $(DISTRIB) && docker build $(build_args) --force-rm -t $(name):$(tag) -f Dockerfile . )

build-scratch:
	@$(MAKE) -C base-image build DISTRIB=$(DISTRIB) VERSION=$(VERSION)

build-all: build-scratch build-image
	echo "# $@"

clean-image:
	-docker ps -f status=exited -a -q | xargs docker rm || true
	-docker images -f dangling=true -a -q| docker rmi || true
