@echo off
@echo Copying DLL to Tridion bin folder
REM copy /Y %1 %2

@echo Copying Configuration to Tridion bin folder
REM copy /Y %3 %4

@echo Starting Tridion Services
REM starting the services again with 'sc start' instead of 'net start' (this is asynchronous so faster)
rem sc start TCMPublisher 
sc start TcmSearchIndexer
REM sc start TcmServiceHost 'this is already started by the TcmSearchIndexer

@echo Done
