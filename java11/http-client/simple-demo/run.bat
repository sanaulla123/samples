@echo off
javac -d mods --module-source-path src src\simpleDemo\info\sanaulla\*.java src\simpleDemo\module-info.java

if %errorlevel% == 1 goto failedCompilation

:runCode
java -p mods -m simpleDemo/info.sanaulla.Main
goto end

:failedCompilation
echo 'Compilation failed'

:end
echo 'Bye!!'