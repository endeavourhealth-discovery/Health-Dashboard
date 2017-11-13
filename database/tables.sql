CREATE TABLE health_dashboard.charts
(
  id INT AUTO_INCREMENT NOT NULL,
  title VARCHAR(50) NOT NULL,
  refresh INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE health_dashboard.chart_definition
(
  id INT NOT NULL,
  connection VARCHAR(255) NOT NULL,
  query VARCHAR(4096) NOT NULL,
  PRIMARY KEY (id)
);