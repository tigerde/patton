FROM ubuntu:14.04
MAINTAINER patton 
# update
RUN apt-get update
# install python
RUN apt-get -yqq install python3.4
# install dependence
RUN apt-get -yqq install python3-pip curl   libcurl4-openssl-dev  libxml2-dev libxslt-dev phantomjs python-lxml libpq-dev
# RUN apt-get build-dep python-lxml
RUN apt-get -yqq install python-pycurl
RUN apt-get -yqq install python-psycopg2
# install requirements
RUN pip3 install --egg 'https://dev.mysql.com/get/Downloads/Connector-Python/mysql-connector-python-2.1.5.zip#md5=ce4a24cb1746c1c8f6189a97087f21c1'
RUN pip3 install Flask>=0.10
RUN pip3 install Jinja2>=2.7
RUN pip3 install chardet>=2.2
RUN pip3 install cssselect>=0.9
RUN pip3 install lxml
RUN pip3 install pycurl
RUN pip3 install pyquery
RUN pip3 install requests>=2.2
RUN pip3 install tornado>=3.2
RUN pip3 install mysql-connector-python>=1.2.2
RUN pip3 install pika>=0.9.14
RUN pip3 install pymongo>=2.7.2
RUN pip3 install unittest2>=0.5.1
RUN pip3 install Flask-Login>=0.2.11
RUN pip3 install u-msgpack-python>=1.6
RUN pip3 install click>=3.3
RUN pip3 install SQLAlchemy>=0.9.7
RUN pip3 install six>=1.5.0
RUN pip3 install amqp>=1.3.0
RUN pip3 install redis
RUN pip3 install redis-py-cluster
# RUN pip3 install kombu
RUN pip3 install psycopg2
RUN pip3 install elasticsearch
RUN pip3 install tblib
RUN pip3 install -U six
# install pyspider
# RUN pip install pyspider
RUN pip3 install --allow-all-external pyspider[all]
# resovle the chartencode
ENV LC_ALL C.UTF-8
ENV LANG C.UTF-8
ENTRYPOINT ["pyspider"]

EXPOSE 5000 23333 24444 25555
