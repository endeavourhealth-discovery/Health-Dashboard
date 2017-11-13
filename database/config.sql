INSERT INTO config.config
(app_id, config_id, config_data)
VALUES
('health-dashboard','database', '{
 	"class" : "com.mysql.cj.jdbc.MysqlDataSource",
 	"dialect" : "org.hibernate.dialect.MySQLDialect",
 	"password" : "<PASSWORD>",
 	"url" : "jdbc:mysql://localhost:3306/health-dashboard?useSSL=false",
 	"username" : "<USERNAME>"
}');