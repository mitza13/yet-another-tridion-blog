@echo off
echo Stopping Tridion Com+ application
cscript %1

echo Stopping Tridion Services
REM stopping the services with 'net stop' instead of 'sc stop' (this is synchronous)
net stop TCMPublisher
net stop TcmSearchIndexer
net stop TcmServiceHost
@echo Done
