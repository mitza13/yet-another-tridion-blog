# Introduction #

SDL Tridion Content Delivery Web Service has a few limitations when it comes querying for content. This article presents an extension to the OData Web Service that allows queries to be passed to the service using the $filter parameter. These queries are executed on the OData server using Criterias and Content Delivery API functionality.

Description of the accepted URL parameters, $filter format, $orderby, $top and $skip for the OData Query Extension.

Parser enhancement to OData Query Extension to support functions such as CustomMetaValue and CustomMetaKey nested queries.

Full code:
  * https://code.google.com/p/yet-another-tridion-blog/source/browse/trunk/OData+Query+Extension

Related blog post:

  * http://yatb.mitza.net/2013/06/extending-odata-query-functionality.html

  * http://yatb.mitza.net/2013/06/url-syntax-for-odata-query-extension.html

  * http://yatb.mitza.net/2013/06/function-support-for-queries-in-odata.html