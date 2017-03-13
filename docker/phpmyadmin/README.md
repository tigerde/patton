### phpmyadmin快速安装
1. 基础docker镜像下载
```bash
docker pull phpmyadmin/phpmyadmin
```
2. phpmyadmin配置文件创建config.inc.php
	```php
	<?php
	$cfg['blowfish_secret']='multiServerExample70518';
	//any string of your choice
	$i = 0;
	//采用cookies记录模式
	$i++; // 配置mysql数据库server 1 :
	$cfg['Servers'][$i]['auth_type'] = 'cookie';
	$cfg['Servers'][$i]['verbose']   = 'data1.huntor.cn';
	$cfg['Servers'][$i]['port']   = '3306';
	$cfg['Servers'][$i]['host']      = 'data1.huntor.cn';
	$cfg['Servers'][$i]['extension'] = 'mysqli';
	// more options for #1 ...
	
	$i++; // 配置mysql数据库server 2 :
	$cfg['Servers'][$i]['auth_type'] = 'cookie';
	$cfg['Servers'][$i]['verbose']   = 'server5';
	$cfg['Servers'][$i]['port']   = '3306';
	$cfg['Servers'][$i]['host']      = '192.168.1.5';
	$cfg['Servers'][$i]['extension'] = 'mysqli';
	// more options for #2 ...
	
	// end of server sections
	$cfg['ServerDefault'] = 0; // to choose the server on startup
	
	// further general options ...
	?>
	```
3. docker-compose文件创建docker-compose.yml
	```yml
	data1_phpmyadmin:
	    image: phpmyadmin/phpmyadmin
	    container_name: data1_phpmyadmin
	    environment:
	     - PMA_ARBITRARY=1
	    restart: always
	    ports:
	     - 8080:80
	    volumes:
	     - conf/config.inc.php:/etc/phpmyadmin/config.inc.php
	```
4. 启动测试
```bash
sudo docker-compose up
```
访问服务查看使用情况http://server:8080
改为自动启动
```bash
sudo docker-compose up -d
```
5. 删除容器
```bash
sudo docker-compose down
```