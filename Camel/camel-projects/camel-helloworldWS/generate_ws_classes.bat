@echo off
ECHO.
ECHO.
ECHO ##################################################################################
ECHO ###
ECHO ### Calling maven goal for generating java class sources out of wsdl:
ECHO ###
ECHO ### mvn clean
ECHO ###
ECHO.
call mvn clean
ECHO.
ECHO ###
ECHO ### mvn cxf-codegen:wsdl2java
ECHO.
call mvn cxf-codegen:wsdl2java
ECHO.
ECHO ###
ECHO ### Finished generating java class sources.
ECHO ###
ECHO ##################################################################################
ECHO.
ECHO.
PAUSE