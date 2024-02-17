docker run --name mysql -d \
    -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=polytec24 \
    -e MYSQL_DATABASE=java_swing \
    --restart unless-stopped \
    mysql:8