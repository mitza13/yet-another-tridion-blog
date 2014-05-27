    Dim oCatalog 'As COMAdminCatalog
    Set oCatalog = CreateObject("ComAdmin.COMAdminCatalog")
    Wscript.Echo "Shutting down SDL Tridion Content Manager"
    Call oCatalog.ShutdownApplication("SDL Tridion Content Manager")
    Wscript.Echo "Completed shutdown process.  Exiting"
    Set oCatalog = Nothing