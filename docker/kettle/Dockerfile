FROM java:8
MAINTAINER patton
WORKDIR /root
RUN apt-get update -yqq\
	&& apt-get install -yqq  git curl\
	&& rm -rf \
    /var/lib/apt/lists/* \
    /tmp/* \
    /var/tmp/* \
    /usr/share/man \
    /usr/share/doc \
    /usr/share/doc-base
	
