docker run --name mysql-container --network app -v mysql-volume:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 -d mysql:latest 
