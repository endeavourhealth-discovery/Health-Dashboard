INSERT INTO health_dashboard.charts
(title, refresh)
VALUES
('Config entries by application', 5);

INSERT INTO health_dashbaord.chart_definition
(id, connection, query)
VALUES
(1, '{
 	"class" : "com.mysql.cj.jdbc.MysqlDataSource",
 	"dialect" : "org.hibernate.dialect.MySQLDialect",
 	"password" : "<PASSWORD>",
 	"url" : "jdbc:mysql://localhost:3306/config?useSSL=false",
 	"username" : "<USERNAME>"
}',
'SELECT "column" AS type, "Configs" AS series, app_id AS category, count(*) AS value
FROM config.config
GROUP BY type, series, category');