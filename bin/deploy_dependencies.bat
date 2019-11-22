cd ../itoken-dependencies
call mvn clean install

cd ../itoken-common
call mvn clean install

cd ../itoken-common-domain
call mvn clean install

cd ../itoken-common-service
call mvn clean install

cd ../itoken-common-web
call mvn clean install

cd ../itoken-common-feign
call mvn clean install

cd ..