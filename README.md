Week4LabA

# First Steps

In src/main/resources, copy the application.properties.dist file to application.properties. Then edit the spring.datasource.password line to a much stronger password. Also, if you want the data to persist, add the line:

```
spring.jpa.hibernate.ddl-auto=update
```
