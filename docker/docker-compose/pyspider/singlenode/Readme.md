# Pyspider Singlenode
## 准备容器mysql以及rabbitmq
参考mysql以及rabbitmq容器初始化
```
docker-compose up -d
```
##　pyspider容器初始化
- 明确外部依赖容器
> 不适用内部容器，因为mysql启动有延迟导致pyspider容器启动时无法连接数据库而失败。

	```yml
	external_links:
	  - mysql
	  - rabbitmq
	```
- 使用命令配置文件
```yml
command: 
```
- 使用config.json配置文件
```yml
volumes:
  - ./config.json:/config.json
command: -c config.json
```
- 启动
```
docker-compose up 
```
- 访问
[http://host:5000](http://host:5000 "http://host:5000")