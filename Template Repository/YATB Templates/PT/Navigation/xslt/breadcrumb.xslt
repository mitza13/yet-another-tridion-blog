<xsl:stylesheet version="1.0"
    xmlns:fn="http://www.w3.org/2005/xpath-functions"
    xmlns:tcm="http://www.tridion.com/ContentManager/5.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    exclude-result-prefixes="fn tcm xsl">

  <xsl:output omit-xml-declaration="yes" method="html" />

  <xsl:param name="PageUri" />

  <xsl:template match="/">
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="tcm:Item[@ID=$PageUri]">
    <xsl:call-template name="breadcrumb-item">
      <xsl:with-param name="current-node" select=".."/>
    </xsl:call-template>

    <b><xsl:value-of select="@DisplayTitle"/></b>

    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template name="breadcrumb-item">
    <xsl:param name="current-node"/>
    <xsl:if test="$current-node/../@Url">
      <xsl:call-template name="breadcrumb-item">
        <xsl:with-param name="current-node" select="$current-node/.."/>
      </xsl:call-template>
    </xsl:if>
    <a href="{$current-node/@Url}/index.html"><xsl:value-of select="$current-node/@DisplayTitle"/></a> &gt;
  </xsl:template>

</xsl:stylesheet>