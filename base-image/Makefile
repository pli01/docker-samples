DISTRIB ?=
VERSION ?=

build: build-$(DISTRIB)
	@echo $(DISTRIB) ${VERSION}

build-$(DISTRIB): build-$(DISTRIB).sh
	@[ -x build-$(DISTRIB).sh ] && echo sudo -E bash -x build-$(DISTRIB)
