@echo off
cls
echo parametrage de la variable d'environnement MYSQL_HOME...
SET MYSQL_HOME=C:\Program Files (x86)\MySQL\MySQL Server 5.1
echo parametrage effectue avec succes.
echo changement de repertoire de travail...
echo changement effectue avec succes.
cd /d %~dp0
echo lancement de l'operation de dumpage :
echo creation de la base de donnees 'db_covoiturage' + dumpage... 
"%MYSQL_HOME%\bin\mysql" -uroot -pafcepf<db_covoiturage.sql
echo operation terminee avec succes.
pause